import { useState } from "react";

import Header from '../../../components/Header';
import Title from '../../../components/Title';

import { Link } from 'react-router-dom';
import { IMaskInput } from "react-imask";

import { toast } from 'react-toastify';
import { FiArchive } from "react-icons/fi";

export default function CadastrarMercadoria() {
  const [dataValidade, setDataValidade] = useState('')
  const [dataFabricacao, setDataFabricacao] = useState('')
  const [dataCadastro, setDataCadastro] = useState('')
  const [nome, setNome] = useState('');
  const [quantidade, setQuantidade] = useState('');
  const [valor, setValor] = useState('');
  const [descricao, setDescricao] = useState('');

  // -----------------------------------------------------

  function handleSubmit() {

  }

  return (
      <><Header />
      
      <div className="content">
      <Title name="Mercadoria">
        <FiArchive color="#8b8da5" size={25} />
      </Title>

      <form className="forms" onSubmit={handleSubmit}>
        <label>Cadastro</label>

        <span>Data de validade</span>
        <input type="date" value={dataValidade} 
        onChange={ (e) => setDataValidade(e.target.value) } />

        <span>Data de fabricação</span>
        <input type="date" value={dataFabricacao} 
        onChange={ (e) => setDataFabricacao(e.target.value) } />

        <span>Data de cadastro</span>
        <input type="date" value={dataCadastro} 
        onChange={ (e) => setDataCadastro(e.target.value) } />

        <input type="text" placeholder="Nome" value={nome}
          onChange={(e) => setNome(e.target.value)} />

        <input type="number" placeholder="Quantidade" value={quantidade}
          onChange={(e) => setQuantidade(e.target.value)} />

        <input type="text" placeholder="Valor" value={valor}
          onChange={(e) => setValor(e.target.value)} />

        <input type="text" placeholder="Descricao" value={descricao}
          onChange={(e) => setDescricao(e.target.value)} />

        <button className="submit" onClick={() => handleSubmit()}>
          Próximo</button>
      </form>
    </div></>
  )
}