import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

import Header from '../../components/Header';
import Title from '../../components/Title';

import { toast } from 'react-toastify';
import { FiArchive, FiX, FiEdit3 } from "react-icons/fi";

export default function Produtos(){
  const [ocorrencia, setOcorrencia] = useState([]);
  const [nomeProduto, setNomeProduto] = useState('');
  const [precoProduto, setPrecoProduto] = useState('');
  
  const [total, setTotal] = useState();

  async function cadastrarProduto(e){
    e.preventDefault();

    toast.success('Produto cadastrado!');
  
    setNomeProduto('');
    setPrecoProduto('');
  }

  useEffect(()=> {

    async function loadProdutos(){

    }

    loadProdutos();
    
  }, []);

  async function excluirProduto(id){

  }

  return(
    <div>
      <Header/>

      <div className="content">
        <Title name="Produto">
          <FiArchive color="#8b8da5" size={25}/>
        </Title>

        <div className="container">
          <form className="forms">
            <label>Cadastrar Produto:</label>
            <input type="text" placeholder="Nome do produto" value={nomeProduto} onChange={ (e) => setNomeProduto(e.target.value) } />
            <input type="text" placeholder="Preço do produto" value={precoProduto} onChange={ (e) => setPrecoProduto(e.target.value) } />
            <button className='submit' onClick={cadastrarProduto}>Cadastrar</button>
          </form>
        </div>

        <i>Total: <strong>{total}</strong></i>

        <table>
          <thead>
            <tr>
              <th scope="col">Produtos cadastrados</th>
              <th scope="col">Preço</th>
              <th scope="col">#</th>
            </tr>
          </thead>
          <tbody>
            {ocorrencia.map((item, index)=>{
              return(
                <tr key={index}>
                  <td data-label="Produto cadastrado">{item.nomeProduto}</td>
                  <td data-label="Preço">{item.precoProduto}</td>
                  <td data-label="#">
                    
                    <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/produtos/${item.id}`}>
                      <FiEdit3 color="#fff" size={17}/>
                    </Link>

                    <button className="action" style={{backgroundColor: '#f00'}} onClick={ () => excluirProduto(item.id) }>
                        <FiX color="#fff" size={17}/>
                    </button>
                    
                  </td>
                </tr>
              )
            })}            
          </tbody>
        </table>
        
      </div>
    </div>
  )
}