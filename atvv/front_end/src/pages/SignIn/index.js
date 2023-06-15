import './signin.css';
import logo from '../../assets/logo.png';
import { useState } from 'react';
import { useNavigate  } from 'react-router-dom';

function SignIn() {
  const [email, setEmail] = useState('autobots@gmail.com');
  const [password, setPassword] = useState('transformers');
  
  const navigate = useNavigate();

  function handleSubmit(e){
    e.preventDefault();
    if(email !== '' && password !== ''){
      navigate('/dashboard');
    }
  }

  return (
    <div className="container-center">
      <div className="login">
        
        <div className="login-area">
          <img src={logo} alt="Autobot logo" />
        </div>

        <form onSubmit={handleSubmit}>
          <h1>Entrar</h1>
          <input type="text" placeholder="Email" value={email} onChange={ (e) => setEmail(e.target.value) }/>
          <input type="password" placeholder="Senha" value={password} onChange={(e) => setPassword(e.target.value) } />
          <button className='singin_button' type="submit">Acessar</button>
        </form>  

      </div>
    </div>
  );
}

export default SignIn;