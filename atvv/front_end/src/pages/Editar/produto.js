import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Header from '../../components/Header';
import Title from '../../components/Title';

import { toast } from 'react-toastify';
import { FiEdit } from 'react-icons/fi';

export default function Produto(){
  const { id } = useParams();
  const navigate = useNavigate();

  const [nomeProduto, setNomeProduto] = useState('');
  const [precoProduto, setPrecoProduto] = useState('');
  const [idProduto, setIdProduto] = useState(false);

  useEffect(()=> {
    async function loadProdutos(){
      
    }
    
    loadProdutos();
  }, [id]);

  async function loadId(lista){
  
  }

  async function handleRegister(e){
    e.preventDefault();

  }

  return(
    <div>
      <Header/>

      <div className="content">
        <Title name="Editar">
          <FiEdit color="#8b8da5" size={25}/>
        </Title>

        <div className="container">

          <form className="forms" onSubmit={handleRegister} >
            
            <label>Produto</label>
            <input
              type="text"
              value={nomeProduto}
              onChange={ (e) => setNomeProduto(e.target.value) }
            />

            <input
              type="text"
              value={precoProduto}
              onChange={ (e) => setPrecoProduto(e.target.value) }
            />

            <button type="submit" className="buttons" >Salvar</button>

          </form>
          
        </div>

      </div>
    </div>
  )
}