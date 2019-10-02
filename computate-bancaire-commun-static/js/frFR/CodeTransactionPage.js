
// POST //

function postCodeTransaction($formulaireValeurs) {
	var vals = {};

	var valeurPk = $formulaireValeurs.find('.valeurPk').val();
	if(valeurPk != null && valeurPk !== '')
		vals['pk'] = valeurPk;

	var valeurCree = $formulaireValeurs.find('.valeurCree').val();
	if(valeurCree != null && valeurCree !== '')
		vals['cree'] = valeurCree;

	var valeurModifie = $formulaireValeurs.find('.valeurModifie').val();
	if(valeurModifie != null && valeurModifie !== '')
		vals['modifie'] = valeurModifie;

	var valeurCodeTransactionId = $formulaireValeurs.find('.valeurCodeTransactionId').val();
	if(valeurCodeTransactionId != null && valeurCodeTransactionId !== '')
		vals['codeTransactionId'] = valeurCodeTransactionId;

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

function patchCodeTransaction($formulaireFiltres, $formulaireValeurs, success, error) {
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

	var filtreCodeTransactionId = $formulaireFiltres.find('.valeurCodeTransactionId').val();
	if(filtreCodeTransactionId != null && filtreCodeTransactionId !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionId:' + filtreCodeTransactionId });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreCodeTransactionNomAffichage = $formulaireFiltres.find('.valeurCodeTransactionNomAffichage').val();
	if(filtreCodeTransactionNomAffichage != null && filtreCodeTransactionNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomAffichage:' + filtreCodeTransactionNomAffichage });

	var filtreId = $formulaireFiltres.find('.valeurId').val();
	if(filtreId != null && filtreId !== '')
		filtres.push({ name: 'fq', value: 'id:' + filtreId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreClasseNomCanonique = $formulaireFiltres.find('.valeurClasseNomCanonique').val();
	if(filtreClasseNomCanonique != null && filtreClasseNomCanonique !== '')
		filtres.push({ name: 'fq', value: 'classeNomCanonique:' + filtreClasseNomCanonique });

	var filtreClasseNomSimple = $formulaireFiltres.find('.valeurClasseNomSimple').val();
	if(filtreClasseNomSimple != null && filtreClasseNomSimple !== '')
		filtres.push({ name: 'fq', value: 'classeNomSimple:' + filtreClasseNomSimple });

	var filtreClasseNomsCanoniques = $formulaireFiltres.find('.valeurClasseNomsCanoniques').val();
	if(filtreClasseNomsCanoniques != null && filtreClasseNomsCanoniques !== '')
		filtres.push({ name: 'fq', value: 'classeNomsCanoniques:' + filtreClasseNomsCanoniques });

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

function getCodeTransaction(pk) {
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

function deleteCodeTransaction(pk) {
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

function rechercheCodeTransaction($formulaireFiltres, success, error) {
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

	var filtreCodeTransactionId = $formulaireFiltres.find('.valeurCodeTransactionId').val();
	if(filtreCodeTransactionId != null && filtreCodeTransactionId !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionId:' + filtreCodeTransactionId });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreCodeTransactionNomAffichage = $formulaireFiltres.find('.valeurCodeTransactionNomAffichage').val();
	if(filtreCodeTransactionNomAffichage != null && filtreCodeTransactionNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomAffichage:' + filtreCodeTransactionNomAffichage });

	var filtreId = $formulaireFiltres.find('.valeurId').val();
	if(filtreId != null && filtreId !== '')
		filtres.push({ name: 'fq', value: 'id:' + filtreId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreClasseNomCanonique = $formulaireFiltres.find('.valeurClasseNomCanonique').val();
	if(filtreClasseNomCanonique != null && filtreClasseNomCanonique !== '')
		filtres.push({ name: 'fq', value: 'classeNomCanonique:' + filtreClasseNomCanonique });

	var filtreClasseNomSimple = $formulaireFiltres.find('.valeurClasseNomSimple').val();
	if(filtreClasseNomSimple != null && filtreClasseNomSimple !== '')
		filtres.push({ name: 'fq', value: 'classeNomSimple:' + filtreClasseNomSimple });

	var filtreClasseNomsCanoniques = $formulaireFiltres.find('.valeurClasseNomsCanoniques').val();
	if(filtreClasseNomsCanoniques != null && filtreClasseNomsCanoniques !== '')
		filtres.push({ name: 'fq', value: 'classeNomsCanoniques:' + filtreClasseNomsCanoniques });

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
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherCodeTransactionVals($formulaireFiltres, success, error);
}
