import { useState } from "react";

import Header from '../../../components/Header';
import Title from '../../../components/Title';

import { Link } from 'react-router-dom';
import { IMaskInput } from "react-imask";

import { toast } from 'react-toastify';
import { FaRegCreditCard } from "react-icons/fa";

export default function CadastrarVenda() {
  const [dataCadastro, setDataCadastro] = useState('')
  const [identificacao, setIdentificacao] = useState('');
  const [nomeCliente, setNomeCliente] = useState('');
  const [nomeFuncionario, setNomeFuncionario] = useState('');

  // -----------------------------------------------------

  function handleSubmit() {

  }

  return (
      <><Header />
      
      <div className="content">
      <Title name="Venda">
        <FaRegCreditCard color="#8b8da5" size={25} />
      </Title>

      <form className="forms" onSubmit={handleSubmit}>
        <label>Cadastro</label>

        <span>Data de cadastro</span>
        <input type="date" value={dataCadastro} 
        onChange={ (e) => setDataCadastro(e.target.value) } />

        <input type="text" placeholder="Identificação" value={identificacao}
          onChange={(e) => setIdentificacao(e.target.value)} />

        <input type="text" placeholder="Nome do Cliente" value={nomeCliente}
          onChange={(e) => setNomeCliente(e.target.value)} />

        <input type="text" placeholder="Nome do Funcionário" value={nomeFuncionario}
          onChange={(e) => setNomeFuncionario(e.target.value)} />

        <button className="submit" onClick={() => handleSubmit()}>
          Próximo</button>
      </form>
    </div></>
  )
}