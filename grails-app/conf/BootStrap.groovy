class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                Funcionalidade.withTransaction {
                    crieFuncionalidades()
                    crieUsuarios()
                }
            }
        }
    }
    def destroy = {
    }

    private void crieUsuarios() {

    }

    private void crieFuncionalidades() {
        Map funcionalidadesPadrao = [
                "Administração": [
                        "Visualizar propriedades avançadas de usuários"
                ],
                "Gerência"     : [
                        "Gerenciar Usuários",
                        "Gerenciar Papéis",
                        "Gerenciar Funcionalidades"
                ]
        ]

        funcionalidadesPadrao.each { String grupo, List funcionalidades ->
            funcionalidades.each { String nomeFuncionalidade ->
                Funcionalidade funcionalidade = Funcionalidade.findOrCreateByGrupoAndNome(grupo, nomeFuncionalidade)
                funcionalidade.save()
            }
        }
    }
}

