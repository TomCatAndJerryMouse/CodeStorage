import React ,{ Component } from 'react';

class Menu extends Component{
    
    render() {
        return (
            <ul >
                {this.props.menuList.map((name)=> <li>{name}</li>)}
            </ul>
        );
    }
}
export default Menu;
