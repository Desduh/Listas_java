import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import Header from '../../components/Header';
import Title from '../../components/Title';

import { toast } from 'react-toastify';
import { FiArchive, FiPlus } from "react-icons/fi";

import '../style.css';

export default function Produtos() {
  const { id } = useParams();

  const id2 = id;
  const [ocorrencia, setOcorrencia] = useState([]);
  const [ocorrencia2, setOcorrencia2] = useState([]);
  const [nomeProduto, setNomeProduto] = useState("");
  const [precoProduto, setPrecoProduto] = useState("");
  const [totalItems, setTotalItems] = useState("");

  // const [total, setTotal] = useState();
  // const totalParse = parseInt(totalItems)

  useEffect(() => {

    async function loadProdutos() {

    }

    async function loadProdutos2() {

    }

    loadProdutos();
    loadProdutos2();

  }, []);



  async function adicionarProduto(id) {
    toast.success('Produto adicionado!');
  }

  // var produtos = 0
  // console.log(ocorrencia2.length);
  // if (ocorrencia2.length > 0) {
  //   var coisas = ocorrencia2[0]
  //   produtos = coisas.produto
  // }

  return (
    <div>
      <Header />

      <div className="content">
        <Title name="Adicionar Produto">
          <FiArchive color="#8b8da5" size={25} />
        </Title>

        <p>Adicionados ao Cliente</p>

        <table>
          <thead>
            <tr>
              <th scope="col">Produto</th>
            </tr>
          </thead>
          <tbody>
          {ocorrencia2.map((item, index) => {
              return (
                <tr key={index}>
                  <td data-label="Produto cadastrado">{item.produto}</td>
                </tr>
              )
            })}

            {/* <tr>
            {produtos!== 0 && produtos.map((item) => {
              return (
                
                  <td className='vertical'  data-label="Produto">{item}</td>
                
              )
            })}
            </tr> */}
          </tbody>
        </table>
        {/* <i>Total: <strong>{total}</strong></i> */}

        <p>Produtos Cadastrados</p>

        <table>
          <thead>
            <tr>
              <th scope="col">Nome</th>
              <th scope="col">Preço</th>
              <th scope="col">Adicionar</th>
            </tr>
          </thead>
          <tbody>
            {ocorrencia.map((item, index) => {
              return (
                <tr key={index}>
                  <td data-label="Produto cadastrado">{item.nomeProduto}</td>
                  <td data-label="Preço">{item.precoProduto}</td>
                  <td data-label="Adicionar">

                    <button className="action" style={{ backgroundColor: '#32CD32' }} onClick={() => adicionarProduto(item.id)}>
                      <FiPlus color="#fff" size={17} />
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