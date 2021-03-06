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
        <title>IFSP Aluno</title>
        <link href="/admin/css/styles.css" rel="stylesheet" />
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
									<a class="nav-link" href="/aluno/aluno/lista">Lista Alunos</a>
									<a class="nav-link" href="/aluno/aluno/aprovado">Lista Aprovados</a>
									<a class="nav-link" href="/aluno/aluno/novo">Novo</a></nav>
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
                        <h1 class="mt-4">Aluno</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Aluno</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
								<a href="/aluno/aluno/novo" class="btn btn-outline-primary">+ Aluno</a>
							</div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header"><i class="fa fa-list-ul"></i> Lista de Alunos</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                                <th>id</th>
                                                <th>nome</th>
                                                <th>matricula</th>
                                                <th>nota</th>
                                            <c:forEach items="${Alunos}" var="alu" varStatus="loopStatus">
                                                <tr>
                                                    <td>${alu.id}</td>
                                                    <td>${alu.nome}</td>
                                                    <td>${alu.matricula}</td>
                                                    <td>${alu.nota}</td>
                                                    <td>
                                                        <a href="/aluno/aluno/editar?id=${alu.id}">
														<i class="fas fa-edit" aria-hidden="true"></i>
													</a>
													<a href="#" class="deleta" id="${alu.id}">
														<i class="fa fa-trash" aria-hidden="true"> </i>
													</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                       </thead> 
                                        <tfoot>
                                            <tr>
                                                <th>id</th>
                                                <th>nome</th>
                                                <th>matricula</th>
                                                <th>nota</th>
                                           </tr>
                                        </tfoot>
                                       
                                    </table>
                                </div>
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
        <script src="/aluno/assets/demo/datatables-demo.js"></script>
        <script>
        $(".deleta").bind('click', function(){
            var id = this.id;
            if (confirm("Deseja deletar o aluno de Código "+id)){
                $.ajax({
                    url: "/aluno/aluno/deleta",
                    type: "post",
                    data: {
                        id : id,
                    },
                    success : function(data){
                        alert('Aluno deletado com sucesso!');
                        location.reload();
                    }
                });
            }
        });
        </script>

    </body>
</html>
