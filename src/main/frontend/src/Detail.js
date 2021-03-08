import React, { useEffect, useState } from 'react';
import { useHistory,useParams } from 'react-router-dom';
import styled from 'styled-components';
import './Detail.scss';
import './App.js';

let 박스 = styled.div`
    padding : 20px;
`;
let 제목 = styled.h4`
    font-size : 25px;
`;


function Detail(props) {

    useEffect(()=>{
        let timer = setTimeout(()=>{ alert변경(false) }, 2000);
        return ()=>{ clearTimeout(timer) }
    },[]);

    let [alert, alert변경] = useState(true);


    let history = useHistory();
    let { id } = useParams();
    let 찾은상품 = props.medicine.find(function(상품){
        return 상품.id == id
    });

    return (
        <div className="container">
            <박스>
                <제목>Detail</제목>
            </박스>

            {
                alert === true
                ?(<div className="my-alert2">
                    <p>재고가 얼마 남지 않았습니다</p>
                  </div>)
                : null
            }

            

            <div className="row">
            <div className="col-md-6">
                <img src={ 'https://github.com/Medicine-Recommend-Project/picture/blob/077931b18736ebec6d656339a2087300b9c12fb8/medicine' + (props.i+1) + '.jpg?raw=true' } width="100%" />
            </div>
            <div className="col-md-6 mt-4">
                <h4 className="pt-5">{찾은상품.title}</h4>
                <p>{찾은상품.content}</p>
                <p>{찾은상품.price}원</p>
                <button className="btn btn-danger">주문하기</button> 
                <button className="btn btn-danger" onClick={()=>{ 
                    history.push('/');
                }}>뒤로가기</button> 
            </div>
            </div>
        </div>  
    )
}



export default Detail;