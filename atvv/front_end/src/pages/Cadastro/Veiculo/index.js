import { useState } from "react";

import Header from '../../../components/Header';
import Title from '../../../components/Title';

import { Link } from 'react-router-dom';
import { IMaskInput } from "react-imask";

import { toast } from 'react-toastify';
import { MdDirectionsCar } from "react-icons/md";

export default function CadastrarVeiculo() {
  const [tipo, setTipo] = useState('');
  const [modelo, setModelo] = useState('');
  const [placa, setPlaca] = useState('');
  const [proprietario, setProprietario] = useState('');


  function handleSubmit() {

  }

  return (
      <><Header />
      
      <div className="content">
      <Title name="Veículo">
        <MdDirectionsCar color="#8b8da5" size={25} />
      </Title>

      <form className="forms" onSubmit={handleSubmit}>
        <label>Cadastro</label>

        <select onChange={e => setTipo(e.target.value)}>
          <option value="HATCH">HATCH</option>
          <option value="SEDAN">SEDAN</option>
          <option value="SUV">SUV</option>
          <option value="PICKUP">PICKUP</option>
          <option value="SW">SW</option>
        </select>

        <input type="text" placeholder="Modelo" value={modelo}
          onChange={(e) => setModelo(e.target.value)} />

        <input type="text" placeholder="Placa" value={placa}
          onChange={(e) => setPlaca(e.target.value)} />

        <input type="text" placeholder="Proprietário" value={proprietario}
          onChange={(e) => setProprietario(e.target.value)} />


        <button className="submit" onClick={() => handleSubmit()}>
          Próximo</button>
      </form>
    </div></>
  )
}