import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {Cadastro} from './Cadastro/cadastro.js';
import {Login} from './Login/login.js';
import {Config} from './Configuracoes/config.js';
import {Loja} from './Loja/loja.js';

import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {createStackNavigator} from '@react-navigation/stack'
import {AntDesign, MaterialIcons} from '@expo/vector-icons';

const Pagina = createStackNavigator();
const Navegacao = createBottomTabNavigator();


class App extends React.Component{
  render(){
    return(
      <NavigationContainer>
        <Navegacao.Navigator>

          <Navegacao.Screen name="Cadastro" component={Cadastro} 
          options={{
            tabBarLabel: "Cadastro",
            tabBarIcon: ({color, size}) => (
            <AntDesign name="adduser" color={color} size={32} />)
          }}
          />

          <Navegacao.Screen name="Login" component={Login} 
          options={{
            tabBarLabel: "Login",
            tabBarIcon: ({color, size}) => (
            <AntDesign name="user" color={color} size={32} />)
          }}
          />

          <Navegacao.Screen name="Loja" component={Loja} 
          options={{
            tabBarLabel: "Loja",
            tabBarIcon: ({color, size}) => (
            <MaterialIcons name="shopping-bag" color={color} size={32} />)
            
          }}
          />


          <Navegacao.Screen name="Configuração" component={Config} 
          options={{
            tabBarLabel: "Carrinho",
            tabBarIcon: ({color, size}) => (
            <AntDesign name="shoppingcart" color={color} size={32} />)
          }}
          />

        </Navegacao.Navigator>
      </NavigationContainer>
    )
  }
}

class Appzin extends React.Component{
  render(){
    return(
      <Pagina.Navigator>
        <Pagina.Screen name="Cadastro" component={Cadastro}/>
        <Pagina.Screen name="Login" component={Login} /> 
        <Pagina.Screen name="Loja" component={Loja} />
        <Pagina.Screen name="Configurações" component={Config} />
      </Pagina.Navigator>
    )
  }
}

export default App;