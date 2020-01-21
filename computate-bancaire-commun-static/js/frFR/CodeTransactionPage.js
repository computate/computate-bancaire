
// POST //

async function postCodeTransaction($formulaireValeurs, success, error) {
	var vals = {};
	if(success == null) {
		success = function( data, textStatus, jQxhr ) {
			ajouterLueur($formulaireValeurs.next('button'));
			var url = data['pageUrlPk'];
			if(url)
				window.location.href = url;
		};
	}
	if(error == null) {
		error = function( jqXhr, textStatus, errorThrown ) {
			ajouterErreur($formulaireValeurs.next('button'));
		};
	}

	var valeurPk = $formulaireValeurs.find('.valeurPk').val();
	if(valeurPk != null && valeurPk !== '')
		vals['pk'] = valeurPk;

	var valeurCree = $formulaireValeurs.find('.valeurCree').val();
	if(valeurCree != null && valeurCree !== '')
		vals['cree'] = valeurCree;

	var valeurModifie = $formulaireValeurs.find('.valeurModifie').val();
	if(valeurModifie != null && valeurModifie !== '')
		vals['modifie'] = valeurModifie;

	var valeurObjetId = $formulaireValeurs.find('.valeurObjetId').val();
	if(valeurObjetId != null && valeurObjetId !== '')
		vals['objetId'] = valeurObjetId;

	var valeurCodeTransactionId = $formulaireValeurs.find('.valeurCodeTransactionId').val();
	if(valeurCodeTransactionId != null && valeurCodeTransactionId !== '')
		vals['codeTransactionId'] = valeurCodeTransactionId;

	var valeurArchive = $formulaireValeurs.find('.valeurArchive').prop('checked');
	if(valeurArchive != null && valeurArchive !== '')
		vals['archive'] = valeurArchive;

	var valeurSupprime = $formulaireValeurs.find('.valeurSupprime').prop('checked');
	if(valeurSupprime != null && valeurSupprime !== '')
		vals['supprime'] = valeurSupprime;

	var valeurTransactionCode = $formulaireValeurs.find('.valeurTransactionCode').val();
	if(valeurTransactionCode != null && valeurTransactionCode !== '')
		vals['transactionCode'] = valeurTransactionCode;

	var valeurCodeTransactionNomAffichage = $formulaireValeurs.find('.valeurCodeTransactionNomAffichage').val();
	if(valeurCodeTransactionNomAffichage != null && valeurCodeTransactionNomAffichage !== '')
		vals['codeTransactionNomAffichage'] = valeurCodeTransactionNomAffichage;

	var valeurCodeTransactionNomComplet = $formulaireValeurs.find('.valeurCodeTransactionNomComplet').val();
	if(valeurCodeTransactionNomComplet != null && valeurCodeTransactionNomComplet !== '')
		vals['codeTransactionNomComplet'] = valeurCodeTransactionNomComplet;

	$.ajax({
		url: '/api/code-transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postCodeTransactionVals(vals, success, error) {
	$.ajax({
		url: '/api/code-transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchCodeTransaction($formulaireFiltres, $formulaireValeurs, success, error) {
	var filtres = patchCodeTransactionFiltres($formulaireFiltres);

	var vals = {};

	var removePk = $formulaireFiltres.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formulaireValeurs.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formulaireValeurs.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formulaireValeurs.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCree = $formulaireFiltres.find('.removeCree').val() === 'true';
	var setCree = removeCree ? null : $formulaireValeurs.find('.setCree').val();
	if(removeCree || setCree != null && setCree !== '')
		vals['setCree'] = setCree;
	var addCree = $formulaireValeurs.find('.addCree').val();
	if(addCree != null && addCree !== '')
		vals['addCree'] = addCree;
	var removeCree = $formulaireValeurs.find('.removeCree').val();
	if(removeCree != null && removeCree !== '')
		vals['removeCree'] = removeCree;

	var removeModifie = $formulaireFiltres.find('.removeModifie').val() === 'true';
	var setModifie = removeModifie ? null : $formulaireValeurs.find('.setModifie').val();
	if(removeModifie || setModifie != null && setModifie !== '')
		vals['setModifie'] = setModifie;
	var addModifie = $formulaireValeurs.find('.addModifie').val();
	if(addModifie != null && addModifie !== '')
		vals['addModifie'] = addModifie;
	var removeModifie = $formulaireValeurs.find('.removeModifie').val();
	if(removeModifie != null && removeModifie !== '')
		vals['removeModifie'] = removeModifie;

	var removeObjetId = $formulaireFiltres.find('.removeObjetId').val() === 'true';
	var setObjetId = removeObjetId ? null : $formulaireValeurs.find('.setObjetId').val();
	if(removeObjetId || setObjetId != null && setObjetId !== '')
		vals['setObjetId'] = setObjetId;
	var addObjetId = $formulaireValeurs.find('.addObjetId').val();
	if(addObjetId != null && addObjetId !== '')
		vals['addObjetId'] = addObjetId;
	var removeObjetId = $formulaireValeurs.find('.removeObjetId').val();
	if(removeObjetId != null && removeObjetId !== '')
		vals['removeObjetId'] = removeObjetId;

	var removeCodeTransactionId = $formulaireFiltres.find('.removeCodeTransactionId').val() === 'true';
	var setCodeTransactionId = removeCodeTransactionId ? null : $formulaireValeurs.find('.setCodeTransactionId').val();
	if(removeCodeTransactionId || setCodeTransactionId != null && setCodeTransactionId !== '')
		vals['setCodeTransactionId'] = setCodeTransactionId;
	var addCodeTransactionId = $formulaireValeurs.find('.addCodeTransactionId').val();
	if(addCodeTransactionId != null && addCodeTransactionId !== '')
		vals['addCodeTransactionId'] = addCodeTransactionId;
	var removeCodeTransactionId = $formulaireValeurs.find('.removeCodeTransactionId').val();
	if(removeCodeTransactionId != null && removeCodeTransactionId !== '')
		vals['removeCodeTransactionId'] = removeCodeTransactionId;

	var removeArchive = $formulaireFiltres.find('.removeArchive').val() === 'true';
	var setArchive = removeArchive ? null : $formulaireValeurs.find('.setArchive').prop('checked');
	if(removeArchive || setArchive != null && setArchive !== '')
		vals['setArchive'] = setArchive;
	var addArchive = $formulaireValeurs.find('.addArchive').prop('checked');
	if(addArchive != null && addArchive !== '')
		vals['addArchive'] = addArchive;
	var removeArchive = $formulaireValeurs.find('.removeArchive').prop('checked');
	if(removeArchive != null && removeArchive !== '')
		vals['removeArchive'] = removeArchive;

	var removeSupprime = $formulaireFiltres.find('.removeSupprime').val() === 'true';
	var setSupprime = removeSupprime ? null : $formulaireValeurs.find('.setSupprime').prop('checked');
	if(removeSupprime || setSupprime != null && setSupprime !== '')
		vals['setSupprime'] = setSupprime;
	var addSupprime = $formulaireValeurs.find('.addSupprime').prop('checked');
	if(addSupprime != null && addSupprime !== '')
		vals['addSupprime'] = addSupprime;
	var removeSupprime = $formulaireValeurs.find('.removeSupprime').prop('checked');
	if(removeSupprime != null && removeSupprime !== '')
		vals['removeSupprime'] = removeSupprime;

	var removeTransactionCode = $formulaireFiltres.find('.removeTransactionCode').val() === 'true';
	var setTransactionCode = removeTransactionCode ? null : $formulaireValeurs.find('.setTransactionCode').val();
	if(removeTransactionCode || setTransactionCode != null && setTransactionCode !== '')
		vals['setTransactionCode'] = setTransactionCode;
	var addTransactionCode = $formulaireValeurs.find('.addTransactionCode').val();
	if(addTransactionCode != null && addTransactionCode !== '')
		vals['addTransactionCode'] = addTransactionCode;
	var removeTransactionCode = $formulaireValeurs.find('.removeTransactionCode').val();
	if(removeTransactionCode != null && removeTransactionCode !== '')
		vals['removeTransactionCode'] = removeTransactionCode;

	var removeCodeTransactionNomAffichage = $formulaireFiltres.find('.removeCodeTransactionNomAffichage').val() === 'true';
	var setCodeTransactionNomAffichage = removeCodeTransactionNomAffichage ? null : $formulaireValeurs.find('.setCodeTransactionNomAffichage').val();
	if(removeCodeTransactionNomAffichage || setCodeTransactionNomAffichage != null && setCodeTransactionNomAffichage !== '')
		vals['setCodeTransactionNomAffichage'] = setCodeTransactionNomAffichage;
	var addCodeTransactionNomAffichage = $formulaireValeurs.find('.addCodeTransactionNomAffichage').val();
	if(addCodeTransactionNomAffichage != null && addCodeTransactionNomAffichage !== '')
		vals['addCodeTransactionNomAffichage'] = addCodeTransactionNomAffichage;
	var removeCodeTransactionNomAffichage = $formulaireValeurs.find('.removeCodeTransactionNomAffichage').val();
	if(removeCodeTransactionNomAffichage != null && removeCodeTransactionNomAffichage !== '')
		vals['removeCodeTransactionNomAffichage'] = removeCodeTransactionNomAffichage;

	var removeCodeTransactionNomComplet = $formulaireFiltres.find('.removeCodeTransactionNomComplet').val() === 'true';
	var setCodeTransactionNomComplet = removeCodeTransactionNomComplet ? null : $formulaireValeurs.find('.setCodeTransactionNomComplet').val();
	if(removeCodeTransactionNomComplet || setCodeTransactionNomComplet != null && setCodeTransactionNomComplet !== '')
		vals['setCodeTransactionNomComplet'] = setCodeTransactionNomComplet;
	var addCodeTransactionNomComplet = $formulaireValeurs.find('.addCodeTransactionNomComplet').val();
	if(addCodeTransactionNomComplet != null && addCodeTransactionNomComplet !== '')
		vals['addCodeTransactionNomComplet'] = addCodeTransactionNomComplet;
	var removeCodeTransactionNomComplet = $formulaireValeurs.find('.removeCodeTransactionNomComplet').val();
	if(removeCodeTransactionNomComplet != null && removeCodeTransactionNomComplet !== '')
		vals['removeCodeTransactionNomComplet'] = removeCodeTransactionNomComplet;

	patchCodeTransactionVals(filtres, vals, success, error);
}

function patchCodeTransactionFiltres($formulaireFiltres) {
	var filtres = [];

	var filtrePk = $formulaireFiltres.find('.valeurPk').val();
	if(filtrePk != null && filtrePk !== '')
		filtres.push({ name: 'fq', value: 'pk:' + filtrePk });

	var filtreCree = $formulaireFiltres.find('.valeurCree').val();
	if(filtreCree != null && filtreCree !== '')
		filtres.push({ name: 'fq', value: 'cree:' + filtreCree });

	var filtreModifie = $formulaireFiltres.find('.valeurModifie').val();
	if(filtreModifie != null && filtreModifie !== '')
		filtres.push({ name: 'fq', value: 'modifie:' + filtreModifie });

	var filtreObjetId = $formulaireFiltres.find('.valeurObjetId').val();
	if(filtreObjetId != null && filtreObjetId !== '')
		filtres.push({ name: 'fq', value: 'objetId:' + filtreObjetId });

	var filtreCodeTransactionId = $formulaireFiltres.find('.valeurCodeTransactionId').val();
	if(filtreCodeTransactionId != null && filtreCodeTransactionId !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionId:' + filtreCodeTransactionId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreCodeTransactionNomAffichage = $formulaireFiltres.find('.valeurCodeTransactionNomAffichage').val();
	if(filtreCodeTransactionNomAffichage != null && filtreCodeTransactionNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomAffichage:' + filtreCodeTransactionNomAffichage });

	var filtreId = $formulaireFiltres.find('.valeurId').val();
	if(filtreId != null && filtreId !== '')
		filtres.push({ name: 'fq', value: 'id:' + filtreId });

	var filtreClasseNomCanonique = $formulaireFiltres.find('.valeurClasseNomCanonique').val();
	if(filtreClasseNomCanonique != null && filtreClasseNomCanonique !== '')
		filtres.push({ name: 'fq', value: 'classeNomCanonique:' + filtreClasseNomCanonique });

	var filtreClasseNomSimple = $formulaireFiltres.find('.valeurClasseNomSimple').val();
	if(filtreClasseNomSimple != null && filtreClasseNomSimple !== '')
		filtres.push({ name: 'fq', value: 'classeNomSimple:' + filtreClasseNomSimple });

	var filtreClasseNomsCanoniques = $formulaireFiltres.find('.valeurClasseNomsCanoniques').val();
	if(filtreClasseNomsCanoniques != null && filtreClasseNomsCanoniques !== '')
		filtres.push({ name: 'fq', value: 'classeNomsCanoniques:' + filtreClasseNomsCanoniques });

	var filtreSessionId = $formulaireFiltres.find('.valeurSessionId').val();
	if(filtreSessionId != null && filtreSessionId !== '')
		filtres.push({ name: 'fq', value: 'sessionId:' + filtreSessionId });

	var filtreObjetTitre = $formulaireFiltres.find('.valeurObjetTitre').val();
	if(filtreObjetTitre != null && filtreObjetTitre !== '')
		filtres.push({ name: 'fq', value: 'objetTitre:' + filtreObjetTitre });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });

	var filtrePageUrlId = $formulaireFiltres.find('.valeurPageUrlId').val();
	if(filtrePageUrlId != null && filtrePageUrlId !== '')
		filtres.push({ name: 'fq', value: 'pageUrlId:' + filtrePageUrlId });

	var filtrePageUrlPk = $formulaireFiltres.find('.valeurPageUrlPk').val();
	if(filtrePageUrlPk != null && filtrePageUrlPk !== '')
		filtres.push({ name: 'fq', value: 'pageUrlPk:' + filtrePageUrlPk });

	var filtreCodeTransactionCle = $formulaireFiltres.find('.valeurCodeTransactionCle').val();
	if(filtreCodeTransactionCle != null && filtreCodeTransactionCle !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionCle:' + filtreCodeTransactionCle });

	var filtreCodeTransactionNomComplet = $formulaireFiltres.find('.valeurCodeTransactionNomComplet').val();
	if(filtreCodeTransactionNomComplet != null && filtreCodeTransactionNomComplet !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomComplet:' + filtreCodeTransactionNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });
	return filtres;
}

function patchCodeTransactionVal(filtres, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchCodeTransactionVals(filtres, vals, success, error);
}

function patchCodeTransactionVals(filtres, vals, success, error) {
	$.ajax({
		url: '/api/code-transaction?' + $.param(filtres)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getCodeTransaction(pk) {
	$.ajax({
		url: '/api/code-transaction/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteCodeTransaction(pk) {
	$.ajax({
		url: '/api/code-transaction/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Recherche //

async function rechercheCodeTransaction($formulaireFiltres, success, error) {
	var filtres = rechercheCodeTransactionFiltres($formulaireFiltres);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	rechercheCodeTransactionVals(filtres, success, error);
}

function rechercheCodeTransactionFiltres($formulaireFiltres) {
	var filtres = [];

	var filtrePk = $formulaireFiltres.find('.valeurPk').val();
	if(filtrePk != null && filtrePk !== '')
		filtres.push({ name: 'fq', value: 'pk:' + filtrePk });

	var filtreCree = $formulaireFiltres.find('.valeurCree').val();
	if(filtreCree != null && filtreCree !== '')
		filtres.push({ name: 'fq', value: 'cree:' + filtreCree });

	var filtreModifie = $formulaireFiltres.find('.valeurModifie').val();
	if(filtreModifie != null && filtreModifie !== '')
		filtres.push({ name: 'fq', value: 'modifie:' + filtreModifie });

	var filtreObjetId = $formulaireFiltres.find('.valeurObjetId').val();
	if(filtreObjetId != null && filtreObjetId !== '')
		filtres.push({ name: 'fq', value: 'objetId:' + filtreObjetId });

	var filtreCodeTransactionId = $formulaireFiltres.find('.valeurCodeTransactionId').val();
	if(filtreCodeTransactionId != null && filtreCodeTransactionId !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionId:' + filtreCodeTransactionId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreCodeTransactionNomAffichage = $formulaireFiltres.find('.valeurCodeTransactionNomAffichage').val();
	if(filtreCodeTransactionNomAffichage != null && filtreCodeTransactionNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomAffichage:' + filtreCodeTransactionNomAffichage });

	var filtreId = $formulaireFiltres.find('.valeurId').val();
	if(filtreId != null && filtreId !== '')
		filtres.push({ name: 'fq', value: 'id:' + filtreId });

	var filtreClasseNomCanonique = $formulaireFiltres.find('.valeurClasseNomCanonique').val();
	if(filtreClasseNomCanonique != null && filtreClasseNomCanonique !== '')
		filtres.push({ name: 'fq', value: 'classeNomCanonique:' + filtreClasseNomCanonique });

	var filtreClasseNomSimple = $formulaireFiltres.find('.valeurClasseNomSimple').val();
	if(filtreClasseNomSimple != null && filtreClasseNomSimple !== '')
		filtres.push({ name: 'fq', value: 'classeNomSimple:' + filtreClasseNomSimple });

	var filtreClasseNomsCanoniques = $formulaireFiltres.find('.valeurClasseNomsCanoniques').val();
	if(filtreClasseNomsCanoniques != null && filtreClasseNomsCanoniques !== '')
		filtres.push({ name: 'fq', value: 'classeNomsCanoniques:' + filtreClasseNomsCanoniques });

	var filtreSessionId = $formulaireFiltres.find('.valeurSessionId').val();
	if(filtreSessionId != null && filtreSessionId !== '')
		filtres.push({ name: 'fq', value: 'sessionId:' + filtreSessionId });

	var filtreObjetTitre = $formulaireFiltres.find('.valeurObjetTitre').val();
	if(filtreObjetTitre != null && filtreObjetTitre !== '')
		filtres.push({ name: 'fq', value: 'objetTitre:' + filtreObjetTitre });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });

	var filtrePageUrlId = $formulaireFiltres.find('.valeurPageUrlId').val();
	if(filtrePageUrlId != null && filtrePageUrlId !== '')
		filtres.push({ name: 'fq', value: 'pageUrlId:' + filtrePageUrlId });

	var filtrePageUrlPk = $formulaireFiltres.find('.valeurPageUrlPk').val();
	if(filtrePageUrlPk != null && filtrePageUrlPk !== '')
		filtres.push({ name: 'fq', value: 'pageUrlPk:' + filtrePageUrlPk });

	var filtreCodeTransactionCle = $formulaireFiltres.find('.valeurCodeTransactionCle').val();
	if(filtreCodeTransactionCle != null && filtreCodeTransactionCle !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionCle:' + filtreCodeTransactionCle });

	var filtreCodeTransactionNomComplet = $formulaireFiltres.find('.valeurCodeTransactionNomComplet').val();
	if(filtreCodeTransactionNomComplet != null && filtreCodeTransactionNomComplet !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomComplet:' + filtreCodeTransactionNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });
	return filtres;
}

function rechercheCodeTransactionVals(filtres, success, error) {
	$.ajax({
		url: '/api/code-transaction?' + $.param(filtres)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggereCodeTransactionObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-code-commit w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['codeTransactionNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrlPk']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherCodeTransactionVals($formulaireFiltres, success, error);
}

function suggereCodeTransactionObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-code-commit w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['codeTransactionNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrlPk']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherCodeTransactionVals($formulaireFiltres, success, error);
}

async function websocketCodeTransaction(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketCodeTransaction', function (error, message) {
			var json = JSON.parse(message['body']);
			var id = json['id'];
			var pk = json['pk'];
			var pks = json['pks'];
			var empty = json['empty'];
			if(!empty) {
				var numFound = json['numFound'];
				var numPATCH = json['numPATCH'];
				var percent = Math.floor( numPATCH / numFound * 100 ) + '%';
				var $box = $('<div>').attr('class', 'w3-display-topright w3-quarter box-' + id + ' ').attr('id', 'box-' + id);
				var $margin = $('<div>').attr('class', 'w3-margin ').attr('id', 'margin-' + id);
				var $card = $('<div>').attr('class', 'w3-card ').attr('id', 'card-' + id);
				var $header = $('<div>').attr('class', 'w3-container fa-yellow ').attr('id', 'header-' + id);
				var $i = $('<i>').attr('class', 'fad fa-code-commit w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modifier code de transactions');
				var $x = $('<span>').attr('class', 'w3-button w3-display-topright ').attr('onclick', '$("#card-' + id + '").hide(); ').attr('id', 'x-' + id);
				var $body = $('<div>').attr('class', 'w3-container w3-padding ').attr('id', 'text-' + id);
				var $bar = $('<div>').attr('class', 'w3-light-gray ').attr('id', 'bar-' + id);
				var $progress = $('<div>').attr('class', 'w3-yellow ').attr('style', 'height: 24px; width: ' + percent + '; ').attr('id', 'progress-' + id).text(numPATCH + '/' + numFound);
				$card.append($header);
				$header.append($i);
				$header.append($headerSpan);
				$header.append($x);
				$body.append($bar);
				$bar.append($progress);
				$card.append($body);
				$box.append($margin);
				$margin.append($card);
				$('.box-' + id).remove();
				if(numPATCH < numFound)
				$('.w3-content').append($box);
				if(success)
					success(json);
			}
		});
	}
}
async function websocketCodeTransactionInner(requetePatch) {
	var pk = requetePatch['pk'];
	var pks = requetePatch['pks'];
	var classes = requetePatch['classes'];
	var vars = requetePatch['vars'];
	var empty = requetePatch['empty'];

	if(pk != null) {
		rechercherCodeTransactionVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('cree')) {
				$('.inputCodeTransaction' + pk + 'Cree').val(o['cree']);
				$('.varCodeTransaction' + pk + 'Cree').text(o['cree']);
			}
			if(vars.includes('modifie')) {
				$('.inputCodeTransaction' + pk + 'Modifie').val(o['modifie']);
				$('.varCodeTransaction' + pk + 'Modifie').text(o['modifie']);
			}
			if(vars.includes('archive')) {
				$('.inputCodeTransaction' + pk + 'Archive').val(o['archive']);
				$('.varCodeTransaction' + pk + 'Archive').text(o['archive']);
			}
			if(vars.includes('supprime')) {
				$('.inputCodeTransaction' + pk + 'Supprime').val(o['supprime']);
				$('.varCodeTransaction' + pk + 'Supprime').text(o['supprime']);
			}
			if(vars.includes('transactionCode')) {
				$('.inputCodeTransaction' + pk + 'TransactionCode').val(o['transactionCode']);
				$('.varCodeTransaction' + pk + 'TransactionCode').text(o['transactionCode']);
			}
			if(vars.includes('codeTransactionNomAffichage')) {
				$('.inputCodeTransaction' + pk + 'CodeTransactionNomAffichage').val(o['codeTransactionNomAffichage']);
				$('.varCodeTransaction' + pk + 'CodeTransactionNomAffichage').text(o['codeTransactionNomAffichage']);
			}
		});
	}

	if(!empty) {
		if(pks) {
			for(i=0; i < pks.length; i++) {
				var pk2 = pks[i];
				var c = classes[i];
				await window['patch' + c + 'Vals']( [ {name: 'fq', value: 'pk:' + pk2} ], {});
			}
		}
		await patchCodeTransactionVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
