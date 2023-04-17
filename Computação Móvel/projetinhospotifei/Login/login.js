import React from 'react';
import {Button, View, Text, TextInput, Alert, AsyncStorage, StyleSheet} from 'react-native';

export class Login extends React.Component{
  constructor(props){
    super(props)
    this.usuario = "",
    this.senha = ""
  }

  ler(){
    AsyncStorage.getItem(this.usuario, (erro, valor)=>{
      if(erro == undefined){
        if(this.senha == valor && valor != null){
          Alert.alert(
            "Login feito com sucesso",
            "",
            [
              { text: "OK", onPress: () => console.log("OK Pressed") }
            ]
          ); 
          return;
        }
        Alert.alert(
          "Login inválido",
          "",
          [
            { text: "OK", onPress: () => console.log("OK Pressed") }
          ]
        ); 
      }
         

    })
    
  }

  render(){
    return(
      <View>
        <Text style={{
          color: '#0000FF',
          height:30,
          width:170,
          fontSize: 20,
          marginLeft: 140,
          marginTop: 180,
        }}>
        Usuário
        </Text>

        <TextInput placeholder="Digite o usuário" onChangeText={(texto)=>{this.usuario = texto}} 
        style={{
          color: '#0000FF',
          height:30,
          width:170,
          marginLeft: 100,
          fontWeight: 'bold',
          fontSize: 20,
          borderColor: '#87CEEB',
          borderWidth:3,
          marginBottom: 10,
          borderRadius: 10,
        }}>
        </TextInput>

        <Text style={{
          color: '#0000FF',
          height:30,
          width:170,
          fontSize: 20,
          marginLeft: 140,
        }}>
        Senha
        </Text>        
        <TextInput placeholder="Digite a senha" onChangeText={(texto)=>{this.senha = texto}} style={{
           color: '#0000FF',
          height:30,
          width:170,
          marginLeft: 100,
          fontWeight: 'bold',
          fontSize: 20,
          borderColor: '#87CEEB',
          borderWidth:3,
          marginBottom: 50,
          borderRadius: 10,
        }}></TextInput>

        <View style={botao.container0}>
        <Button title="Login" onPress={()=>this.ler()}/>
        </View>
      </View>
    )
  }
}

const botao = StyleSheet.create({
  container0: {
          height:50,
          width:170,
          marginLeft: 100,
          fontSize: 20,
          borderColor: '#87CEEB',
          borderWidth:3,
          marginBottom: 10,
          backgroundColor: '#87CEEB',
          borderRadius: 10,
   },
})