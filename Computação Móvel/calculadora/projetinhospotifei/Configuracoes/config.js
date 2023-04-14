import React from 'react';
import {Button, View, Text, TextInput, Alert, AsyncStorage} from 'react-native';

export class Playlist extends React.Component{
  constructor(props){
    super(props)
    this.usuario = "",
    this.senha = ""
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



  componentDidMount() {
    const { navigation } = this.props;
    this.focusListener = navigation.addListener('focus', () => {
    Alert.alert(
      "Acesso não autorizado!",
      "Você precisa logar para ver a Playlist!",
      [
        { text: "OK", onPress: () => console.log("OK Pressed") }
      ]
    ); 
    this.props.navigation.navigate("Login")
    }
    )

  }

  render(){
    return(

      <View>
      <Text>Oi</Text>
      </View>
    )
  }
}