import React ,{ Component } from "react";

// 无状态组件的写法适用于 、
// 不操作state组件
// 只依赖props传入参数
// 不需要用到生命周期
const Header = (props) =>{
    return (
        <div style={{width:'100%'}} ><h1> This is Header! </h1> </div>
    );
}
export default Header;