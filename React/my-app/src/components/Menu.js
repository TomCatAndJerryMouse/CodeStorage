import React ,{ Component } from 'react';
import { NavLink ,Router} from "react-router-dom";

class Menu extends Component{

    // 遍历菜单，遍历数据react需要为每个遍历出来的元素添加一个唯一的key属性
    render() {
        return (
            <ul >
                {this.props.menuList.map((name,key)=>
                     <NavLink activeStyle ={{fontSize:'25px'}} to={"/" + name}><li key={key}>{name}</li></NavLink>)}
            </ul>
        );
    }
}
export default Menu;
