import React ,{ Component } from 'react';

class Menu extends Component{

    // 遍历菜单，遍历数据react需要为每个遍历出来的元素添加一个唯一的key属性
    render() {
        return (
            <ul >
                {this.props.menuList.map((name,key)=> <li key={key}>{name}</li>)}
            </ul>
        );
    }
}
export default Menu;
