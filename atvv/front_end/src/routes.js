import { Routes, Route } from 'react-router-dom';

import SignIn from './pages/SignIn';
import Dashboard from './pages/Dashboard';

import Cadastrar from './pages/Cadastro';

import CadastrarCliente from './pages/Cadastro/Cliente';
import Cliente from './pages/Editar/cliente';
import TodosClientes from './pages/Listagens/clientes';

import CadastrarEmpresa from './pages/Cadastro/Empresa';
import TodasEmpresas from './pages/Listagens/empresas';

import CadastrarVeiculo from './pages/Cadastro/Veiculo';

import CadastrarServico from './pages/Cadastro/Servico';

import CadastrarMercadoria from './pages/Cadastro/Mercadoria';

import CadastrarVenda from './pages/Cadastro/Venda';

import Produtos from './pages/Produtos';
import Produto from './pages/Editar/produto';
import AddProdutos from './pages/Add/produto';

import CincoValor from './pages/Listagens/5valor';

export default function RoutesApp(){
  return(
    <Routes>
      <Route exact path="/" element={ <SignIn/> } />
      <Route exact path="/dashboard" element={ <Dashboard/> } />
      
      <Route exact path="/cadastrar" element={ <Cadastrar/> } />
      
      <Route exact path="/cliente" element={ <CadastrarCliente/> } />
      <Route exact path="/clientes/:id" element={ <Cliente/> } />
      <Route exact path="/listagem_clientes" element={ <TodosClientes/> } />
      
      <Route exact path="/empresa" element={ <CadastrarEmpresa/> } />
      <Route exact path="/listagem_empresas" element={ <TodasEmpresas/> } />
      
      <Route exact path="/veiculo" element={ <CadastrarVeiculo/> } />
      
      <Route exact path="/servico" element={ <CadastrarServico/> } />

      <Route exact path="/mercadoria" element={ <CadastrarMercadoria/> } />

      <Route exact path="/venda" element={ <CadastrarVenda/> } />

      <Route exact path="/produtos" element={ <Produtos/> } />
      <Route exact path="/produtos/:id" element={ <Produto/> } />

      <Route exact path="/adicionar_produtos/:id" element={ <AddProdutos/> } />

      <Route exact path="/5valor" element={ <CincoValor/> } />
    
    </Routes>
  )
}
