import '../style.css';
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

import Header from '../../components/Header';
import Title from '../../components/Title';

import ModalDetalhes from '../../components/ModalDetalhes/cliente';

import { MdPeopleOutline } from "react-icons/md";
import { FiArchive, FiX, FiSearch, FiEdit3 } from "react-icons/fi";

export default function TodosClientes(){
  const [ocorrencia, setOcorrencia] = useState([]);
    
  const [showPostModal, setShowPostModal] = useState(false);
  const [detail, setDetail] = useState();

  const [total, setTotal] = useState();

  useEffect(()=> {

    async function loadClientes(){

    }

    loadClientes();
    
  }, []);

  async function excluirCliente(id){

  }

  function togglePostModal(item){
    setShowPostModal(!showPostModal);
    setDetail(item);
  }

  return(
    <div>
      <Header/>

      <div className="content">
        <Title name="Listagem dos Clientes">
          <MdPeopleOutline color="#8b8da5" size={25}/>
        </Title>          

        <i>Total: <strong>{total}</strong></i>

        <table>
          <thead>
            <tr>
              <th scope="col">Cliente cadastrado</th>
              <th scope="col">Ações</th>
              
            </tr>
          </thead>
          <tbody>
            {/* {ocorrencia.map((item, index)=>{
              return(
                <tr key={index}>
                  <td data-label="Cliente cadastrado">{item.nomeCliente}</td>
                  <td data-label="Ações">
                    <button className="action" style={{backgroundColor: '#3583f6'}} onClick={ () => togglePostModal(item) }>
                        <FiSearch color="#fff" size={17}/>
                    </button>

                    <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/clientes/${item.id}`}>
                      <FiEdit3 color="#fff" size={17}/>
                    </Link>

                    <button className="action" style={{backgroundColor: '#f00'}} onClick={ () => excluirCliente(item.id) }>
                        <FiX color="#fff" size={17}/>
                    </button>
                  </td>
                </tr>
              )
            })}   */}

            {/* {ocorrencia.map((item, index)=>{ 
              return(*/}
                <tr>
                  <td data-label="Cliente cadastrado">Amanda Caires Pereira</td>
                  <td data-label="Ações">
                    <button className="action" style={{backgroundColor: '#3583f6'}} onClick={ () => togglePostModal() }>
                        <FiSearch color="#fff" size={17}/>
                    </button>

                    <Link className="action" style={{backgroundColor: '#F6a935'}} to={`/clientes`}>
                      <FiEdit3 color="#fff" size={17}/>
                    </Link>

                    <button className="action" style={{backgroundColor: '#f00'}} onClick={ () => excluirCliente() }>
                        <FiX color="#fff" size={17}/>
                    </button>
                  </td>
                </tr>
             {/* )
             })}             */}          
          </tbody>
        </table>
        
      </div>
      {showPostModal && (
        <ModalDetalhes
          conteudo={detail}
          close={togglePostModal}
        />
      )}
    </div>
  )
}