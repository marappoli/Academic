import * as React from 'react';
import { Text } from 'react-native';

class Hora extends React.Component{
  constructor(props){
    super(props);
    console.log("Construtor");
  }

  componentWillUnmount(){
    console.log("Desmontado!")
  }

  componentDidMount(){
    console.log("Acabou de ser montado!");
  }

  componentDidUpdate(){
    console.log("Acabou de atualizar");
  }

  render(){
    return(
      <Text style={{color: '#B9A2F2', 
                    fontSize: 25, 
                    fontWeight: 'bold',
                    alignSelf: 'center' }}>{this.props.children}</Text>
    )
  }
}

export default Hora;