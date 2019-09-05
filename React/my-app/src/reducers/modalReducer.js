const modalReducer = (state = {visible: false}, action = {}) => {
    switch(action.type) {
      case 'SHOWMODAL':
        console.log('sssssssssssssssssss');
        state.visible = true;
        return state;
      case 'CLOSEMODAL':
        return state - 1;
      default: return state;
    }
  }
  
  export default modalReducer;