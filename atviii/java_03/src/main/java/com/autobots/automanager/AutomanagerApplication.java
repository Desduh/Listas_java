package com.autobots.automanager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Email;
import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Mercadoria;
import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.entidades.Venda;
import com.autobots.automanager.enumeracoes.PerfilUsuario;
import com.autobots.automanager.enumeracoes.TipoDocumento;
import com.autobots.automanager.enumeracoes.TipoVeiculo;
import com.autobots.automanager.repositorios.RepositorioEmpresa;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public RepositorioEmpresa repositorioEmpresa;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Tudo carros LTDA");
			empresa.setNomeFantasia("Tudo carros");
			empresa.setCadastro(new Date());

			Endereco enderecoEmpresa = new Endereco();
			enderecoEmpresa.setEstado("São Paulo");
			enderecoEmpresa.setCidade("São Jasé dos Campos");
			enderecoEmpresa.setBairro("Centro");
			enderecoEmpresa.setRua("Av. Cidade Jardim");
			enderecoEmpresa.setNumero("2000");
			enderecoEmpresa.setCodigoPostal("12233-002");

			empresa.setEndereco(enderecoEmpresa);

			Telefone telefoneEmpresa = new Telefone();
			telefoneEmpresa.setDdd("011");
			telefoneEmpresa.setNumero("986454527");

			empresa.getTelefones().add(telefoneEmpresa);
			
			

			Usuario funcionario = new Usuario();
			funcionario.setNome("Carlos Eduardo Falandes");
			funcionario.setNomeSocial("Edu");
			funcionario.getPerfis().add(PerfilUsuario.FUNCIONARIO);

			Email emailFuncionario = new Email();
			emailFuncionario.setEndereco("edu@gmail.com");

			funcionario.getEmails().add(emailFuncionario);

			Endereco enderecoFuncionario = new Endereco();
			enderecoFuncionario.setEstado("São Paulo");
			enderecoFuncionario.setCidade("São José dos Campos");
			enderecoFuncionario.setBairro("Interlagos");
			enderecoFuncionario.setRua("Rua. Antônio Boarini");
			enderecoFuncionario.setNumero("3000");
			enderecoFuncionario.setCodigoPostal("12229-130");

			funcionario.setEndereco(enderecoFuncionario);

			empresa.getUsuarios().add(funcionario);

			Telefone telefoneFuncionario = new Telefone();
			telefoneFuncionario.setDdd("012");
			telefoneFuncionario.setNumero("988372758");

			funcionario.getTelefones().add(telefoneFuncionario);

			Documento cpf = new Documento();
			cpf.setDataEmissao(new Date());
			cpf.setNumero("49985842863");
			cpf.setTipo(TipoDocumento.CPF);

			funcionario.getDocumentos().add(cpf);

			CredencialUsuarioSenha credencialFuncionario = new CredencialUsuarioSenha();
			credencialFuncionario.setInativo(false);
			credencialFuncionario.setNomeUsuario("carlosfalandes");
			credencialFuncionario.setSenha("fatec");
			credencialFuncionario.setCriacao(new Date());
			credencialFuncionario.setUltimoAcesso(new Date());

			funcionario.getCredenciais().add(credencialFuncionario);
			
			

			Usuario fornecedor = new Usuario();
			fornecedor.setNome("Júlia");
			fornecedor.setNomeSocial("Ju");
			fornecedor.getPerfis().add(PerfilUsuario.FORNECEDOR);

			Email emailFornecedor = new Email();
			emailFornecedor.setEndereco("ju@gmail.com");

			fornecedor.getEmails().add(emailFornecedor);

			CredencialUsuarioSenha credencialFornecedor = new CredencialUsuarioSenha();
			credencialFornecedor.setInativo(false);
			credencialFornecedor.setNomeUsuario("juliafornecedora");
			credencialFornecedor.setSenha("fatec");
			credencialFornecedor.setCriacao(new Date());
			credencialFornecedor.setUltimoAcesso(new Date());

			fornecedor.getCredenciais().add(credencialFornecedor);

			Documento cnpj = new Documento();
			cnpj.setDataEmissao(new Date());
			cnpj.setNumero("12345678000190");
			cnpj.setTipo(TipoDocumento.CNPJ);

			fornecedor.getDocumentos().add(cnpj);

			Endereco enderecoFornecedor = new Endereco();
			enderecoFornecedor.setEstado("São Paulo");
			enderecoFornecedor.setCidade("São Paulo");
			enderecoFornecedor.setBairro("Vila Mariana");
			enderecoFornecedor.setRua("Rua da Consolação");
			enderecoFornecedor.setNumero("123");
			enderecoFornecedor.setCodigoPostal("01001-000");

			fornecedor.setEndereco(enderecoFornecedor);

			empresa.getUsuarios().add(fornecedor);
			
			

			Mercadoria rodaLigaLeve = new Mercadoria();
			rodaLigaLeve.setCadastro(new Date());
			rodaLigaLeve.setFabricao(new Date());
			rodaLigaLeve.setNome("Roda de liga leve modelo Volkswagen Golf");
			rodaLigaLeve.setValidade(new Date());
			rodaLigaLeve.setQuantidade(50);
			rodaLigaLeve.setValor(350.0);
			rodaLigaLeve.setDescricao("Roda de liga leve original de fábrica da Volkswagen para modelos do tipo hatchback");

			empresa.getMercadorias().add(rodaLigaLeve);

			fornecedor.getMercadorias().add(rodaLigaLeve);
			
			

			Usuario cliente = new Usuario();
			cliente.setNome("Maria da Silva");
			cliente.setNomeSocial("Maria");
			cliente.getPerfis().add(PerfilUsuario.CLIENTE);

			Email emailCliente = new Email();
			emailCliente.setEndereco("maria.silva@gmail.com");

			cliente.getEmails().add(emailCliente);

			Documento cpfCliente = new Documento();
			cpfCliente.setDataEmissao(new Date());
			cpfCliente.setNumero("12345678901");
			cpfCliente.setTipo(TipoDocumento.CPF);

			cliente.getDocumentos().add(cpfCliente);

			CredencialUsuarioSenha credencialCliente = new CredencialUsuarioSenha();
			credencialCliente.setInativo(false);
			credencialCliente.setNomeUsuario("mariacliente");
			credencialCliente.setSenha("fatec");
			credencialCliente.setCriacao(new Date());
			credencialCliente.setUltimoAcesso(new Date());

			cliente.getCredenciais().add(credencialCliente);

			Endereco enderecoCliente = new Endereco();
			enderecoCliente.setEstado("Rio de Janeiro");
			enderecoCliente.setCidade("Niterói");
			enderecoCliente.setBairro("Icaraí");
			enderecoCliente.setRua("Rua Presidente Backer");
			enderecoCliente.setNumero("123");
			enderecoCliente.setCodigoPostal("24220-020");

			cliente.setEndereco(enderecoCliente);
			
			
			Veiculo veiculo = new Veiculo();
			veiculo.setPlaca("XYZ-1234");
			veiculo.setModelo("Gol");
			veiculo.setTipo(TipoVeiculo.SUV);
			veiculo.setProprietario(cliente);

			cliente.getVeiculos().add(veiculo);

			empresa.getUsuarios().add(cliente);
			
			Servico trocaRodas = new Servico();
			trocaRodas.setDescricao("Substituição das rodas do carro por modelos esportivos");
			trocaRodas.setNome("Troca de rodas esportivas");
			trocaRodas.setValor(150);
			
			Servico alinhamento = new Servico();
			alinhamento.setDescricao("Alinhamento e balanceamento das rodas do veículo");
			alinhamento.setNome("Alinhamento e balanceamento de rodas");
			alinhamento.setValor(80);

			empresa.getServicos().add(trocaRodas);
			empresa.getServicos().add(alinhamento);

			Venda venda = new Venda();
			venda.setCadastro(new Date());
			venda.setCliente(cliente);
			venda.getMercadorias().add(rodaLigaLeve);
			venda.setIdentificacao("1234698745");
			venda.setFuncionario(funcionario);
			venda.getServicos().add(trocaRodas);
			venda.getServicos().add(alinhamento);
			venda.setVeiculo(veiculo);
			veiculo.getVendas().add(venda);

			empresa.getVendas().add(venda);

			repositorioEmpresa.save(empresa);

		}
	}
}
