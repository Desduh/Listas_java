import '../style.css';
import { useState } from 'react';

import Header from '../../components/Header';
import Title from '../../components/Title';

import { toast } from 'react-toastify';
import { FiCalendar } from "react-icons/fi";

export default function CincoValor() {

  const [opcao, setOpcao] = useState('valorTotal');
  const [listagem, setListagem] = useState([]);
  const [total, setTotal] = useState();

  async function lista5valor(e) {
    e.preventDefault();
    
  }

  function handleChangeSelect(e) {
    setOpcao(e.target.value);
  }

  return (
    <div>
      <Header />

      <div className="content">
        <Title name="Listagem">
          <FiCalendar color="#8b8da5" size={25} />
        </Title>

        <p>Mais consumiram em valor</p>

        <div className="container">
          <form className="form-student">
            <label>Pesquisa por:</label>
            <select value={opcao} onChange={handleChangeSelect} className="selected">
              <option value="valorTotal">Todos</option>
              <option value="valorGastoPro">Produtos</option>
              <option value="valorGastoSer">Serviços</option>
            </select>

            <button className='submit' onClick={lista5valor}>Procurar</button>
          </form>
        </div>


        <i>Total: <strong>{total}</strong></i>
        <table id="dataTable">
          <thead>
            <tr>
              <th scope="col">Resultado</th>
            </tr>
          </thead>
          <tbody>
            {listagem.map((item, index) => {
              return (
                <tr key={index}>
                  <td data-label="Resultado">{item.nomeCliente}</td>
                </tr>
              )
            })}
          </tbody>
        </table>
      </div>
    </div>
  )
}