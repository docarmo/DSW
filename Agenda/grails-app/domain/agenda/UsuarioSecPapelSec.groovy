package agenda

import org.apache.commons.lang.builder.HashCodeBuilder

class UsuarioSecPapelSec implements Serializable {

	UsuarioSec usuarioSec
	PapelSec papelSec

	boolean equals(other) {
		if (!(other instanceof UsuarioSecPapelSec)) {
			return false
		}

		other.usuarioSec?.id == usuarioSec?.id &&
			other.papelSec?.id == papelSec?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (usuarioSec) builder.append(usuarioSec.id)
		if (papelSec) builder.append(papelSec.id)
		builder.toHashCode()
	}

	static UsuarioSecPapelSec get(long usuarioSecId, long papelSecId) {
		find 'from UsuarioSecPapelSec where usuarioSec.id=:usuarioSecId and papelSec.id=:papelSecId',
			[usuarioSecId: usuarioSecId, papelSecId: papelSecId]
	}

	static UsuarioSecPapelSec create(UsuarioSec usuarioSec, PapelSec papelSec, boolean flush = false) {
		new UsuarioSecPapelSec(usuarioSec: usuarioSec, papelSec: papelSec).save(flush: flush, insert: true)
	}

	static boolean remove(UsuarioSec usuarioSec, PapelSec papelSec, boolean flush = false) {
		UsuarioSecPapelSec instance = UsuarioSecPapelSec.findByUsuarioSecAndPapelSec(usuarioSec, papelSec)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(UsuarioSec usuarioSec) {
		executeUpdate 'DELETE FROM UsuarioSecPapelSec WHERE usuarioSec=:usuarioSec', [usuarioSec: usuarioSec]
	}

	static void removeAll(PapelSec papelSec) {
		executeUpdate 'DELETE FROM UsuarioSecPapelSec WHERE papelSec=:papelSec', [papelSec: papelSec]
	}

	static mapping = {
		id composite: ['papelSec', 'usuarioSec']
		version false
	}
}
