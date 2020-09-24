<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>IFSP Loja</title>
        <link href="/Loja/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html">IFSP</a>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Menu Principal</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts"
                                ><div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Aluno
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
									<a class="nav-link" href="/Loja/aparelho/lista">Lista Aparelhos</a>
									<a class="nav-link" href="/Loja/aparelho/lista/novo">Lista Novos</a>
                                    <a class="nav-link" href="/Loja/aparelho/lista/usado">Lista Usados</a>
									<a class="nav-link" href="/Loja/aparelho/novo">Cadastrar Aparelho</a></nav>
                            </div>
                            <!--
							<a class="nav-link" href="#"
                                ><div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Novo link
							</a> -->
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Disciplina:</div>
                        LP2A4
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Aparelhos</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Aparelhos</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
								<a href="/Loja/aparelho/lista" class="btn btn-outline-primary">Lista de Aparelhos</a>
                                <a href="/Loja/aparelho/lista/novo" class="btn btn-outline-primary">Novos</a>
                                <a href="/Loja/aparelho/lista/usado" class="btn btn-outline-primary">Usados</a>
							</div>

							
							<c:forEach items="${mensagens}" var="mensagem">
								<div class="alert alert-warning alert-dismissible fade show" role="alert">
									${mensagem}
									<button type="button" class="close" data-dismiss="alert" arial-label="Close">
										<span aria-hidden="true"> &times;</span>
									</button>
                        		</div>
                   		 	</c:forEach> <!--janela de mensagem - campos faltante-->

                   		 	<c:if test = "${not empty sucess}">
                   		 		<div class="alert alert-success alert-dismissible fade show" role="alert">
									${sucess}
									<button type="button" class="close" data-dismiss="alert" arial-label="Close">
										<span aria-hidden="true"> &times;</span>
									</button>
                        		</div>
                        	</c:if> <!--janela de mensagem - aluno cadastrado com sucesso-->


                        <div class="card mb-4">
                            <div class="card-header"><i class="fas fa-table mr-1"></i>Novo Aparelho</div>
                            <div class="card-body">
                                <form method="post" action="/Loja/aparelho/novo" >
                                    <input type="hidden" name="id" value="${id}">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
														<label class="small mb-1" for="marca">Marca</label>
														<input class="form-control" id="marca" name="marca" value="${marca}" type="text" placeholder="Marca Completo" />
													</div>
                                                </div>
                                               
                                            </div>
                                            <div class="form-group">
												<label class="small mb-1" for="modelo">Modelo</label>
												<input class="form-control" id="modelo" type="modelo" name="modelo" value="${modelo}" aria-describedby="emailHelp" placeholder="Informe o modelo" /></div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
													<label class="small mb-1" for="ano">Ano</label>
													<input class="form-control" id="ano" name="ano" value="${ano}" type="text" placeholder="Informe o ano" /></div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="small mb-1" for="tipo">Tipo</label>
                                                        <select id="tipo" name="tipo" class="form-control" >
                                                            <option selected disabled>Selecione...</option>
                                                            <option value="novo">Aparelho Novo</option>
                                                            <option value="usado">Aparelho Usado</option>
                                                        </select>
                                                    </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                    <label class="small mb-1" for="preco">Preço</label>
                                                    <input class="form-control" id="preco" name="preco" value="${preco}" type="text" placeholder="Informe o preco" /></div>
                                                </div>
                                                
                                            </div>
                                            <div class="form-group mt-4 mb-0">
													<input class="btn btn-primary btn-block" type="submit" value="Salvar">
											</div>
                                    </form>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Prof. Felipe</div>
                            <div>
                                Versão 1.0
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="/Loja/assets/demo/datatables-demo.js"></script>
    </body>
</html>
