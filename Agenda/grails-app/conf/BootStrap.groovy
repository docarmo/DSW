import agenda.*
import grails.plugins.springsecurity.*

class BootStrap {
    def springSecurityService
    
    def init = { servletContext ->
        def usuarioPapel = PapelSec.findByAuthority("ROLE_USER") ?:
        new PapelSec(authority:"ROLE_USER", name:"USUARIO").save()
        def adminPapel = PapelSec.findByAuthority("ROLE_ADMIN") ?:
        new PapelSec(authority:"ROLE_ADMIN", name:"ADMINISTRADOR").save()

        if (Usuario.findAll().isEmpty()) {
            println "populando usuarios"
            def admin = new Usuario(
                username: "admin",
                password: "admin",
                nome: "Administrador",
                enabled: true
            )
            admin.save()
            if (admin.hasErrors()) {
                println admin.errors
            }
            
            UsuarioSecPapelSec.create(admin, adminPapel)
            
            def maria = new Usuario(
                username: "maria",
                password: "maria",
                nome: "Maria",
                enabled: true
            )
            maria.save()
            if (maria.hasErrors()) {
                println maria.errors
            }
            
            UsuarioSecPapelSec.create(maria, usuarioPapel)
        }
        if (Cidade.findAll().isEmpty()) {
            println "populando cidades"
            for (String line: ListaCidades.cidades) {
                def cidade = line.split(",")
                new Cidade(estado: cidade[0], nome: cidade[1]).save()
            }
        }
        if (Contato.findAll().isEmpty()) {
            def maria = Usuario.findByUsername('maria')
       
            def rj = Cidade.findByNome('Rio de Janeiro')
            def bh = Cidade.findByNome('Belo Horizonte')
            def ana = new Contato(nome:'Ana Barros', endereco:'R. B',
                complemento:'Bloco D', cidade: bh, fixo:'(31)3175-5566',
                celular:'(31)8642-1345',
                dataNasc:new GregorianCalendar(1989, Calendar.DECEMBER, 7).time,
                principal:'ana@ana.com',
                alternativo:'alternativo@ana.com',
                homepage:'http://maria.com',
                usuario: maria)
            ana.save()
            if (ana.hasErrors()) {
                println ana.errors
            }
            
            def beto = new Contato(nome:'Roberto Silva', endereco:'R. B',
                complemento:'Bloco C', cidade: rj, fixo:'(21)2468-1357',
                celular:'(21)9753-8246',
                dataNasc:new GregorianCalendar(1978, Calendar.AUGUST, 13).time,
                principal:'beto@beto.com',
                alternativo:'alternativo@beto.com',
                homepage:'http://beto.com',
                usuario: maria)
            beto.save()
            if (beto.hasErrors()) {
                println beto.errors
            }
        }
    }
    def destroy = {
    }
}
