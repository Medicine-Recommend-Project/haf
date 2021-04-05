/* eslint-disable */

import React, {useState} from 'react';
import logo from './logo.svg';
import './App.css';
import Data from './data.js';
import { Navbar,Nav,NavDropdown,Button,Jumbotron } from 'react-bootstrap';
import { Link, Route, Switch } from 'react-router-dom';
import Detail from './Detail.js';
import axios from 'axios';

function App() {

    let [medicine, medicineAlteration] = useState(Data);

    return (
        <div className="App">

            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <Navbar.Brand href="/">성규몰</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">

                        <NavDropdown title="Shopping" id="collasible-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>

                        <NavDropdown title="Brand" id="collasible-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>

                        <NavDropdown title="고민별 케어" id="collasible-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    <Nav>
                        <Nav.Link><Link to="/login">Login</Link></Nav.Link>
                        <Nav.Link><Link to="/cart">Cart</Link></Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>




            <Route exact path="/">
                <Jumbotron className="background">
                    <h1>20% Season OFF</h1><br/>
                    <p>
                        <Button variant="primary">주문하러 가기</Button>
                    </p><br/>

                    <p>
                        특별 가격은 해당 제품 첫 주문시 계정당 1개, 제품 당 1개, 주문 당 1개에만 적용됩니다.<br/>
                        만약 한 주문에서 동일 특가 상품을 1개 이상 주문하면 장바구니에서 자동으로 1개만 세일가가 적용됩니다.<br/>
                        중복 할인은 적용되지 않으며 체험특가 선택은 장바구니에서도 가능합니다.<br/>
                    </p>
                </Jumbotron>

                <div className="container">
                    <div className="row">
                        {
                            medicine.map((a,i)=>{
                                return <Card medicine={medicine[i]} i={i} key={i}/> // ==<Card medicine={a}/>
                            })
                        }
                    </div>
                    <button className="btn btn-primary" onClick={()=>{
                        // 데이터 요청할 URL
                        axios.get('https://github.com/Medicine-Recommend-Project/picture/blob/2b20c4adb0e5708e9af79593c782b38eb4e6e9ad/data2.json')
                            .than((result)=>{
                                console.log(result.data)
                                medicineAlteration( [...medicine, ...result.data ] );
                            })
                            .catch(()=>{
                                console.log('실패')
                            })
                    }}>상품 더보기</button>
                </div>
            </Route>


            <Route exact path="/detail/:id">
                <Detail medicine={medicine}/>
            </Route>


        </div>
    );
}



function Card(props){
    return(
        <div className="col-md-3">
            <img src={ 'https://github.com/Medicine-Recommend-Project/picture/blob/077931b18736ebec6d656339a2087300b9c12fb8/medicine' + (props.i+1) + '.jpg?raw=true' } width="100%" />
            <h4>{ props.medicine.title }</h4>
            <p>{ props.medicine.content }</p>
            <p>{ props.medicine.price }원</p>
        </div>
    )
}




export default App;
