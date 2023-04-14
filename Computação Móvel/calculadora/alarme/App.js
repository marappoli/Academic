import * as React from 'react';
import { Text, View,TextInput, StyleSheet, Image} from 'react-native';
import Hora from './components/Hora'
import { Audio } from 'expo-av';


class App extends React.Component{
  constructor(props){
    super(props);
    this.cont = 0;
    this.state={
      data: new Date()
    }
    this.h=0;
    this.m=0;
  }

  componentDidMount(){
    this.ID = setInterval(()=>this.tick(), 1000);
  }

  componentDidUpdate(){
    this.cont += 1;
  }

  tick(){
    this.setState({data: new Date()});
  }


  render(){
    let hora = null;
    hora =  <Hora>{this.state.data.toLocaleTimeString('pt-BR')}</Hora>
    let min = this.state.data.getMinutes();
    let hour = this.state.data.getHours();
    let imagem = null;
    if(this.m == min && this.h == hour){
      imagem = <Image 
          source={require('./assets/alarm.gif')} 
          style={{width: 340, height: 150, resizeMode: 'center'}} 
          />
      audio = Audio.Sound.createAsync(require('./assets/doorbell-4.mp3'),
      {shouldPlay: true});
    }else{
      null;
    }
    return(
        
        <View  
          style={{display: 'flex', 
                  flexDirection:'column', 
                  justifyContent: 'center', height: '100%',
                  backgroundColor: "#FFF"}}>

          <Text style={{textAlign:'center', 
          marginBottom: 10,
          fontSize:30,
          color:'#B9A2F2',
          fontWeight: 'bold'}}>{'Alarme'}</Text>

          <Text style={{textAlign:'center', 
          fontSize:25,
          color:'#B9A2F2',
          fontWeight: 'bold'}}>{'Hora'}</Text>


          <TextInput style = {styles.input}
              placeholderTextColor = "#B9A2F2"
              autoCapitalize = "none"
              onChangeText={(texto) =>{ this.h = parseInt(texto) }
          } ></TextInput>

          <Text style={{textAlign:'center', 
          fontSize:25,
          color:'#B9A2F2',
          fontWeight: 'bold'}}>{'Minuto'}</Text>
          
          <TextInput style = {styles.input}
              placeholderTextColor = "#B9A2F2"
              autoCapitalize = "none"
              onChangeText={(texto) =>{this.m = parseInt(texto) }
          } ></TextInput>

          <Text> </Text>

          {imagem}

          
          {hora}  
          <Text 
            style={{color: '#B9A2F2', 
                    fontSize: 25, 
                    fontWeight: 'bold',
                    alignSelf: 'center' }}>{this.state.data.getDate()}/{this.state.data.getMonth()+1}/{this.state.data.getFullYear()}</Text>
           
        </View>
        
        
    )
  }
}
export default App;
const styles = StyleSheet.create({
   input: {
      fontSize:25,
      fontWeight: 'bold',
      color: '#B9A2F2',
      marginTop: 10,
      marginBottom: 10,
      height: 50,
      width:90,
      borderColor: '#B9A2F2',
      borderWidth:3,
      alignSelf: 'center'
   },
   
})