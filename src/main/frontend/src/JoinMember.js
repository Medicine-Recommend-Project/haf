import React from "react";

function JoinMember(){

    return(
        <div>
            <h3>성규몰 회원 가입</h3>
            <form action={"/join"} method={"get"}>
                <table>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="cId" placeholder="아이디 입력"/></td>
                    </tr>
                    <tr>
                        <td>PassWord</td>
                        <td><input type="password" name="cPw"/></td>
                    </tr>
                    <tr>
                        <td>PassWord Again</td>
                        <td><input type="password"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email"/></td>
                        {/*
                        <td>
                            <select>
                                <option value="">--Please choose an option--</option>
                                <option value="naver">@naver.com</option>
                                <option value="daum">@daum.net</option>
                                <option value="google">@gmail.com</option>
                            </select>
                        </td>
                        */}
                    </tr>
                </table>
                 <br/>

            </form>
        </div>
    );
}
export default JoinMember;