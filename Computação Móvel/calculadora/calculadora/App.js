import React from 'react';
import { Text, View, Button, TextInput, StyleSheet } from 'react-native';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      op: '',
      resultado: '',
      v1: '',
      v2: '',
    }
  }

soma() {
  this.setState({resultado: (this.state.v1 + this.state.v2)});
}
multiplicacao(){
  this.setState({resultado: this.state.v1 * this.state.v2});
}

subtracao(){
  this.setState({resultado: this.state.v1 - this.state.v2});
}

divisao(){

  this.setState({resultado: this.state.v1 / this.state.v2});
}

operacao(Op) {
  this.setState({op: Op});
}

igual() {
  if (this.state.op == "sum") 
  {
    this.soma();
  }

  if (this.state.op == "mul") {
    this.multiplicacao();
  }

  if (this.state.op == "sub") {
    this.subtracao();
  }

  if (this.state.op == "div") {
    this.divisao();
  }

}

numero(Num) {
  if (this.state.v1 == '') {
    this.setState({ v1: Num });
  } else {
    this.setState({ v2: Num });
  }
}

limpar() {
  this.setState({
    resultado: '',
    v1: '',
    v2: '',
  });
}

  render() {
    return (
      <View style={{display: 'flex', 
                  flexDirection:'column', 
                  justifyContent: 'center', height: '100%',
                  backgroundColor: "#FFF"}}>

        <Text style={{
          color: '#B9A2F2',
          height:30,
          width:170,
          marginLeft: 60,
          fontWeight: 'bold',
          fontSize: 20,
          borderColor: '#B9A2F2',
          borderWidth:3,
          marginBottom: 10
        }}>
          {this.state.resultado}
        </Text>
                  
        <View style={botao.container0}>
        <Button
          title="7"
          color="#B9A2F2"
          onPress={() => this.numero(7)}></Button>
        </View>

        <View style={botao.container1}>
        <Button
          title="8"
          color="#B9A2F2"
          onPress={() => this.numero(8)}></Button>
        </View>

          <View style={botao.container2}>
        <Button
          title="9"
          color="#B9A2F2"
          onPress={() => this.numero(9)}></Button>
        </View>

          <View style={botao.container3}>
        <Button
          title="4"
          color="#B9A2F2"
          onPress={() => this.numero(4)}></Button>
        </View>

          <View style={botao.container4}>
        <Button
          title="5"
          color="#B9A2F2"
          onPress={() => this.numero(5)}></Button>
        </View>

          <View style={botao.container5}>
        <Button
          title="6"
          color="#B9A2F2"
          onPress={() => this.numero(6)}></Button>
        </View>

         <View style={botao.container6}>
        <Button
          title="1"
          color="#B9A2F2"
          onPress={() => this.numero(1)}></Button>
        </View>

         <View style={botao.container7}>
        <Button
          title="2"
          color="#B9A2F2"
          onPress={() => this.numero(2)}></Button>
        </View>

         <View style={botao.container8}>
        <Button
          title="3"
          color="#B9A2F2"
          onPress={() => this.numero(3)}></Button>
        </View>

          <View style={botao.container9}>
        <Button
          title="0"
          color="#B9A2F2"
          onPress={() => this.numero(0)}></Button>
        </View>

        <View style={botao.limpa}>
        <Button
          title="C"
          color="#B9A2F2"
          onPress={() => this.limpar()}></Button>
        </View>
        
        <View style={botao.igual}>
        <Button
          title="="
          color="#B9A2F2"
          onPress={() => this.igual()}></Button>
        </View>

          <View style={botao.soma}>
        <Button
          title="+"
          color="#B9A2F2"
          onPress={() => this.operacao("sum")}></Button>
        </View>

          <View style={botao.subtrai}>
        <Button
          title="-"
          color="#B9A2F2"
          onPress={() => this.operacao("sub")}></Button>
        </View>
          
          <View style={botao.multiplica}>
        <Button
          title="X"
          color="#B9A2F2"
          onPress={() => this.operacao("mul")}></Button>
        </View>
          
          <View style={botao.divide}>
        <Button
          title="/"
          color="#B9A2F2"
          onPress={() => this.operacao("div")}></Button>
        </View>

      </View>
    );
  }
}

export default App;
const botao = StyleSheet.create({
   container0: {
      color: '#B9A2F2',
      height:50,
      marginBottom: -50,
      width:50,
      marginLeft: 60
   },
   container1: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginBottom: -50,
      marginLeft: 120,
   },
   container2: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginLeft: 180,
      marginBottom: -10,
   },
   container3: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginBottom: -50,
      marginLeft: 60
   },
   container4: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginLeft: 120,
      marginBottom: -50,
   },
   container5: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginLeft: 180,
      marginBottom: -10,
   },
   container6: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginBottom: -50,
      marginLeft: 60
   },
   container7: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginLeft: 120,
      marginBottom: -50,
   },
   container8: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginLeft: 180,
      marginBottom: -10,
   },
   container9: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginBottom: -50,
      marginLeft: 120,
   },
   limpa: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginBottom: -50,
      marginLeft: 60,
   },
   igual: {
      color: '#B9A2F2',
      height:50,
      width:50,
      marginBottom: -10,
      marginLeft: 180,
   },
   soma: {
      color: '#B9A2F2',
      height:50,
      width:80,
      marginBottom: -50,
      marginLeft: 60,
   },
   subtrai: {
      color: '#B9A2F2',
      height:50,
      width:80,
      marginBottom: -10,
      marginLeft: 151,
   },
   divide: {
      color: '#B9A2F2',
      height:50,
      width:80,
      marginLeft: 151,
   },
   multiplica: {
      color: '#B9A2F2',
      height:50,
      width:80,
      marginBottom: -50,
      marginLeft: 60,
   },
   
   
})
