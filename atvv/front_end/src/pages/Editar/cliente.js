import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Header from '../../components/Header';
import Title from '../../components/Title';

import { toast } from 'react-toastify';
import { FiEdit } from 'react-icons/fi';

export default function Produto(){
  const { id } = useParams();
  const navigate = useNavigate();

  const [nomeCliente, setNomeCliente] = useState('');
  const [nomeSocial, setNomeSocial] = useState('');
  const [genero, setGenero] = useState('');
  const [telefone, setTelefone] = useState('');
  const [cpf, setCpf] = useState('');
  const [dataCpf, setDataCpf] = useState('');
  const [formValue, setFormValue] = useState([{ rg: "" }])
  const [formValue2, setFormValue2] = useState([{ dataRg: "" }])
  const [idCliente, setIdCliente] = useState(false);

  useEffect(()=> {
    async function loadClientes(){
      
    }

    loadClientes();
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
            
            <label>Cliente</label>
            <input
              type="text"
              value={nomeCliente}
              onChange={ (e) => setNomeCliente(e.target.value) }
            />

            <input
              type="text"
              value={nomeSocial}
              onChange={ (e) => setNomeSocial(e.target.value) }
            />

            <input
              type="text"
              value={genero}
              onChange={ (e) => setGenero(e.target.value) }
            />

            <input
              type="text"
              value={telefone}
              onChange={ (e) => setTelefone(e.target.value) }
            />

            <input
              type="text"
              value={cpf}
              onChange={ (e) => setCpf(e.target.value) }
            />

            <input
              type="text"
              value={dataCpf}
              onChange={ (e) => setDataCpf(e.target.value) }
            />

            <input
              type="text"
              value={formValue}
              onChange={ (e) => setFormValue(e.target.value) }
            />

            <input
              type="text"
              value={formValue2}
              onChange={ (e) => setFormValue2(e.target.value) }
            />

            <button type="submit" className="buttons" >Salvar</button>

          </form>
          
        </div>

      </div>
    </div>
  )
}