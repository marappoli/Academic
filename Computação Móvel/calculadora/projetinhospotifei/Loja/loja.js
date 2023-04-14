import React from 'react';
import {Button, View, Text, Alert, AsyncStorage, Image, StyleSheet, Animated, TouchableOpacity, ScrollView, Vibration} from 'react-native';

export class Loja extends React.Component{
  constructor(props){
    super(props)
    this.usuario = "",
    this.senha = ""
  }
  state = {
    animation: new Animated.Value(1),
  };

  state2 = {
    animation2: new Animated.Value(1),
  };

  state3 = {
    animation3: new Animated.Value(1),
  };

  state4 = {
    animation4: new Animated.Value(1),
  };

  startAnimation = () => {
    Animated.timing(this.state.animation, {
      toValue: 2,
      duration: 1500
    }).start(() => {
      this.state.animation.setValue(1);
    });
  }

  startAnimation2 = () => {
    Animated.timing(this.state2.animation2, {
      toValue: 2,
      duration: 1500
    }).start(() => {
      this.state2.animation2.setValue(1);
    });
  }

  startAnimation3 = () => {
    Animated.timing(this.state3.animation3, {
      toValue: 2,
      duration: 1500
    }).start(() => {
      this.state3.animation3.setValue(1);
    });
  }

  startAnimation4 = () => {
    Animated.timing(this.state4.animation4, {
      toValue: 2,
      duration: 1500
    }).start(() => {
      this.state4.animation4.setValue(1);
    });
  }

  ler(){
    AsyncStorage.getItem(this.usuario, (erro, valor)=>{
      if(erro == undefined && valor != null){
        if(this.senha == valor){
         
          alert("AAAAAAAAAAAAAAA")
        } else {

        }
      }
          Alert.alert(
            "Logado com sucesso!",
            "",
            [
              { text: "OK", onPress: () => console.log("OK Pressed") }
            ]
          ); 

    })
  }



  //componentDidMount() {
    //const { navigation } = this.props;
    //this.focusListener = navigation.addListener('focus', () => {
    //Alert.alert(
      //"Acesso não autorizado!",
      //"Você precisa logar para acessar a loja!",
      //[
        //{ text: "OK", onPress: () => console.log("OK Pressed") }
      //]
    //); 
    //this.props.navigation.navigate("Login")
    //}
    //)

  //}

  render(){
    const animatedStyles = {
      transform: [
        { scale: this.state.animation }
      ]
    }

    const animatedStyles2 = {
      transform: [
        { scale: this.state2.animation2 }
      ]
    }

    const animatedStyles3 = {
      transform: [
        { scale: this.state3.animation3 }
      ]
    }

    const animatedStyles4 = {
      transform: [
        { scale: this.state4.animation4 }
      ]
    }
    return(
      <ScrollView>
      <View style={{
        borderColor: '#0000FF',
        borderWidth: 3, 
        borderTopWidth: 0,
        borderLeftWidth: 0,
        borderRightWidth: 0,
        marginTop: 1,
        marginBottom: 70,
        }}></View>
        <Animated.View style={[animatedStyles]}>
          <TouchableOpacity onPress={this.startAnimation}>
            <Image  
              source={require('./kitArduino.jpg')} 
              style={{
              width: 120, 
              height: 120, 
              borderColor: '#87CEEB',
              borderWidth: 3, 
              borderRadius: 10,
              marginLeft: 125,
            }}/>
          </TouchableOpacity>
        </Animated.View>

      <Text style={{
        color: '#0000FF',
        height:30,
        width:300,
        fontSize: 15,
        fontWeight: 'bold',
        marginLeft: 90,
        marginTop: 70,
        }}> Kit Arduino - R$359,80 </Text>
        <View style={botao.container0}>
        <Button
          title="Comprar"
          color='#0000FF'
          onPress={() => Vibration.vibrate()}></Button>
        </View>
        <View style={{
          borderColor: '#0000FF',
          borderWidth: 3, 
          borderTopWidth: 0,
          borderLeftWidth: 0,
          borderRightWidth: 0,
          marginTop: 20,
          marginBottom: 70,
        }}></View>
          
          
        <Animated.View style={[animatedStyles2]}>
          <TouchableOpacity onPress={this.startAnimation2}>
            <Image  
              source={require('./placa.png')} 
              style={{
              width: 120, 
              height: 120, 
              borderColor: '#87CEEB',
              borderWidth: 3, 
              borderRadius: 10,
              marginLeft: 125,
            }}/>
          </TouchableOpacity>
        </Animated.View>
        <Text style={{
          color: '#0000FF',
        height:30,
        width:300,
        fontSize: 15,
        fontWeight: 'bold',
        marginLeft: 75,
        marginTop: 70,
        }}> Placa WEMOS D1 - R$55,80 </Text>
        <View style={botao.container0}>
        <Button
          title="Comprar"
          color='#0000FF'
          onPress={() => Vibration.vibrate()}></Button>
        </View>
        <View style={{
          borderColor: '#0000FF',
          borderWidth: 3, 
          borderTopWidth: 0,
          borderLeftWidth: 0,
          borderRightWidth: 0,
          marginTop: 20,
          marginBottom: 70,
        }}></View>


        <Animated.View style={[animatedStyles3]}>
          <TouchableOpacity onPress={this.startAnimation3}>
            <Image  
              source={require('./leds.jpg')} 
              style={{
              width: 120, 
              height: 120, 
              borderColor: '#87CEEB',
              borderWidth: 3, 
              borderRadius: 10,
              marginLeft: 125,
            }}/>
          </TouchableOpacity>
        </Animated.View>
        <Text style={{
          color: '#0000FF',
        height:30,
        width:300,
        fontSize: 15,
        fontWeight: 'bold',
        marginLeft: 120,
        marginTop: 70,
        }}> Kit Leds - R$4,90 </Text>
        <View style={botao.container0}>
        <Button
          title="Comprar"
          color='#0000FF'
          onPress={() => Vibration.vibrate()}></Button>
        </View>
        <View style={{
          borderColor: '#0000FF',
          borderWidth: 3, 
          borderTopWidth: 0,
          borderLeftWidth: 0,
          borderRightWidth: 0,
          marginTop: 20,
          marginBottom: 70,
        }}>
        </View>

      
       <Animated.View style={[animatedStyles4]}>
          <TouchableOpacity onPress={this.startAnimation4}>
            <Image  
              source={require('./display.jpg')} 
              style={{
              width: 120, 
              height: 120, 
              borderColor: '#87CEEB',
              borderWidth: 3, 
              borderRadius: 10,
              marginLeft: 125,
            }}/>
          </TouchableOpacity>
        </Animated.View>
        <Text style={{
         color: '#0000FF',
        height:30,
        width:300,
        fontSize: 15,
        fontWeight: 'bold',
        marginLeft: 70,
        marginTop: 70,
        }}> Display LCD 16x2 - R$35,50 </Text>
        <View style={botao.container0}>
        <Button
          title="Comprar"
          color='#0000FF'
          onPress={() => Vibration.vibrate()}></Button>
        </View>
        <View style={{
          borderColor: '#0000FF',
          borderWidth: 3, 
          borderTopWidth: 0,
          borderLeftWidth: 0,
          borderRightWidth: 0,
          marginTop: 20,
          marginBottom: 70,
        }}>
        </View>
      </ScrollView>
    )
  }
}

const botao = StyleSheet.create({
  container0: {
      height:50,
      width:100,
      borderColor: '#87CEEB',
      borderWidth:2,
      marginBottom: 20,
      backgroundColor: '#87CEEB',
      borderRadius: 10,
      marginLeft: 140,
  }
})