import React from 'react';
import {Button, View, Text, TextInput, AsyncStorage, StyleSheet} from 'react-native';

export class Cadastro extends React.Component{
  constructor(props){
    super(props)
    this.usuario = "";
    this.senha = "";
  }
  
    irProLogin(){
    this.props.navigation.navigate("Login")
  }


  gravar(){
    AsyncStorage.setItem(this.usuario, this.senha, (erro)=>{
      if(erro == undefined){
        alert("Cadastrado com sucesso!")
        this.props.navigation.navigate("Login")
      }
      else{
        alert("Erro!")
      }
    });
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
        <Button title="Cadastro" onPress={()=>this.gravar()}/>
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
