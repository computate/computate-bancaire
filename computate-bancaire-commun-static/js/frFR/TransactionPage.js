
// POST //

function postTransactionBancaire($formulaireValeurs) {
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

	var valeurTransactionId = $formulaireValeurs.find('.valeurTransactionId').val();
	if(valeurTransactionId != null && valeurTransactionId !== '')
		vals['transactionId'] = valeurTransactionId;

	var valeurCompteCle = $formulaireValeurs.find('.valeurCompteCle').val();
	if(valeurCompteCle != null && valeurCompteCle !== '')
		vals['compteCle'] = valeurCompteCle;

	var valeurTransactionCode = $formulaireValeurs.find('.valeurTransactionCode').val();
	if(valeurTransactionCode != null && valeurTransactionCode !== '')
		vals['transactionCode'] = valeurTransactionCode;

	var valeurTransactionFrais = $formulaireValeurs.find('.valeurTransactionFrais').prop('checked');
	if(valeurTransactionFrais != null && valeurTransactionFrais !== '')
		vals['transactionFrais'] = valeurTransactionFrais;

	var valeurTransactionNomAffichage = $formulaireValeurs.find('.valeurTransactionNomAffichage').val();
	if(valeurTransactionNomAffichage != null && valeurTransactionNomAffichage !== '')
		vals['transactionNomAffichage'] = valeurTransactionNomAffichage;

	var valeurTransactionIdReference = $formulaireValeurs.find('.valeurTransactionIdReference').val();
	if(valeurTransactionIdReference != null && valeurTransactionIdReference !== '')
		vals['transactionIdReference'] = valeurTransactionIdReference;

	var valeurTransactionMontant = $formulaireValeurs.find('.valeurTransactionMontant').val();
	if(valeurTransactionMontant != null && valeurTransactionMontant !== '')
		vals['transactionMontant'] = valeurTransactionMontant;

	var valeurTransactionDateHeure = $formulaireValeurs.find('.valeurTransactionDateHeure').val();
	if(valeurTransactionDateHeure != null && valeurTransactionDateHeure !== '')
		vals['transactionDateHeure'] = valeurTransactionDateHeure;

	var valeurTransactionNomComplet = $formulaireValeurs.find('.valeurTransactionNomComplet').val();
	if(valeurTransactionNomComplet != null && valeurTransactionNomComplet !== '')
		vals['transactionNomComplet'] = valeurTransactionNomComplet;

	$.ajax({
		url: '/api/transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postTransactionBancaireVals(vals, success, error) {
	$.ajax({
		url: '/api/transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

function patchTransactionBancaire($formulaireFiltres, $formulaireValeurs, success, error) {
	var filtres = patchTransactionBancaireFiltres($formulaireFiltres);

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

	var removeTransactionId = $formulaireFiltres.find('.removeTransactionId').val() === 'true';
	var setTransactionId = removeTransactionId ? null : $formulaireValeurs.find('.setTransactionId').val();
	if(removeTransactionId || setTransactionId != null && setTransactionId !== '')
		vals['setTransactionId'] = setTransactionId;
	var addTransactionId = $formulaireValeurs.find('.addTransactionId').val();
	if(addTransactionId != null && addTransactionId !== '')
		vals['addTransactionId'] = addTransactionId;
	var removeTransactionId = $formulaireValeurs.find('.removeTransactionId').val();
	if(removeTransactionId != null && removeTransactionId !== '')
		vals['removeTransactionId'] = removeTransactionId;

	var removeCompteCle = $formulaireFiltres.find('.removeCompteCle').val() === 'true';
	var setCompteCle = removeCompteCle ? null : $formulaireValeurs.find('.setCompteCle').val();
	if(removeCompteCle || setCompteCle != null && setCompteCle !== '')
		vals['setCompteCle'] = setCompteCle;
	var addCompteCle = $formulaireValeurs.find('.addCompteCle').val();
	if(addCompteCle != null && addCompteCle !== '')
		vals['addCompteCle'] = addCompteCle;
	var removeCompteCle = $formulaireValeurs.find('.removeCompteCle').val();
	if(removeCompteCle != null && removeCompteCle !== '')
		vals['removeCompteCle'] = removeCompteCle;

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

	var removeTransactionFrais = $formulaireFiltres.find('.removeTransactionFrais').val() === 'true';
	var setTransactionFrais = removeTransactionFrais ? null : $formulaireValeurs.find('.setTransactionFrais').prop('checked');
	if(removeTransactionFrais || setTransactionFrais != null && setTransactionFrais !== '')
		vals['setTransactionFrais'] = setTransactionFrais;
	var addTransactionFrais = $formulaireValeurs.find('.addTransactionFrais').prop('checked');
	if(addTransactionFrais != null && addTransactionFrais !== '')
		vals['addTransactionFrais'] = addTransactionFrais;
	var removeTransactionFrais = $formulaireValeurs.find('.removeTransactionFrais').prop('checked');
	if(removeTransactionFrais != null && removeTransactionFrais !== '')
		vals['removeTransactionFrais'] = removeTransactionFrais;

	var removeTransactionNomAffichage = $formulaireFiltres.find('.removeTransactionNomAffichage').val() === 'true';
	var setTransactionNomAffichage = removeTransactionNomAffichage ? null : $formulaireValeurs.find('.setTransactionNomAffichage').val();
	if(removeTransactionNomAffichage || setTransactionNomAffichage != null && setTransactionNomAffichage !== '')
		vals['setTransactionNomAffichage'] = setTransactionNomAffichage;
	var addTransactionNomAffichage = $formulaireValeurs.find('.addTransactionNomAffichage').val();
	if(addTransactionNomAffichage != null && addTransactionNomAffichage !== '')
		vals['addTransactionNomAffichage'] = addTransactionNomAffichage;
	var removeTransactionNomAffichage = $formulaireValeurs.find('.removeTransactionNomAffichage').val();
	if(removeTransactionNomAffichage != null && removeTransactionNomAffichage !== '')
		vals['removeTransactionNomAffichage'] = removeTransactionNomAffichage;

	var removeTransactionIdReference = $formulaireFiltres.find('.removeTransactionIdReference').val() === 'true';
	var setTransactionIdReference = removeTransactionIdReference ? null : $formulaireValeurs.find('.setTransactionIdReference').val();
	if(removeTransactionIdReference || setTransactionIdReference != null && setTransactionIdReference !== '')
		vals['setTransactionIdReference'] = setTransactionIdReference;
	var addTransactionIdReference = $formulaireValeurs.find('.addTransactionIdReference').val();
	if(addTransactionIdReference != null && addTransactionIdReference !== '')
		vals['addTransactionIdReference'] = addTransactionIdReference;
	var removeTransactionIdReference = $formulaireValeurs.find('.removeTransactionIdReference').val();
	if(removeTransactionIdReference != null && removeTransactionIdReference !== '')
		vals['removeTransactionIdReference'] = removeTransactionIdReference;

	var removeTransactionMontant = $formulaireFiltres.find('.removeTransactionMontant').val() === 'true';
	var setTransactionMontant = removeTransactionMontant ? null : $formulaireValeurs.find('.setTransactionMontant').val();
	if(removeTransactionMontant || setTransactionMontant != null && setTransactionMontant !== '')
		vals['setTransactionMontant'] = setTransactionMontant;
	var addTransactionMontant = $formulaireValeurs.find('.addTransactionMontant').val();
	if(addTransactionMontant != null && addTransactionMontant !== '')
		vals['addTransactionMontant'] = addTransactionMontant;
	var removeTransactionMontant = $formulaireValeurs.find('.removeTransactionMontant').val();
	if(removeTransactionMontant != null && removeTransactionMontant !== '')
		vals['removeTransactionMontant'] = removeTransactionMontant;

	var removeTransactionDateHeure = $formulaireFiltres.find('.removeTransactionDateHeure').val() === 'true';
	var setTransactionDateHeure = removeTransactionDateHeure ? null : $formulaireValeurs.find('.setTransactionDateHeure').val();
	if(removeTransactionDateHeure || setTransactionDateHeure != null && setTransactionDateHeure !== '')
		vals['setTransactionDateHeure'] = setTransactionDateHeure;
	var addTransactionDateHeure = $formulaireValeurs.find('.addTransactionDateHeure').val();
	if(addTransactionDateHeure != null && addTransactionDateHeure !== '')
		vals['addTransactionDateHeure'] = addTransactionDateHeure;
	var removeTransactionDateHeure = $formulaireValeurs.find('.removeTransactionDateHeure').val();
	if(removeTransactionDateHeure != null && removeTransactionDateHeure !== '')
		vals['removeTransactionDateHeure'] = removeTransactionDateHeure;

	var removeTransactionNomComplet = $formulaireFiltres.find('.removeTransactionNomComplet').val() === 'true';
	var setTransactionNomComplet = removeTransactionNomComplet ? null : $formulaireValeurs.find('.setTransactionNomComplet').val();
	if(removeTransactionNomComplet || setTransactionNomComplet != null && setTransactionNomComplet !== '')
		vals['setTransactionNomComplet'] = setTransactionNomComplet;
	var addTransactionNomComplet = $formulaireValeurs.find('.addTransactionNomComplet').val();
	if(addTransactionNomComplet != null && addTransactionNomComplet !== '')
		vals['addTransactionNomComplet'] = addTransactionNomComplet;
	var removeTransactionNomComplet = $formulaireValeurs.find('.removeTransactionNomComplet').val();
	if(removeTransactionNomComplet != null && removeTransactionNomComplet !== '')
		vals['removeTransactionNomComplet'] = removeTransactionNomComplet;

	patchTransactionBancaireVals(filtres, vals, success, error);
}

function patchTransactionBancaireFiltres($formulaireFiltres) {
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

	var filtreTransactionId = $formulaireFiltres.find('.valeurTransactionId').val();
	if(filtreTransactionId != null && filtreTransactionId !== '')
		filtres.push({ name: 'fq', value: 'transactionId:' + filtreTransactionId });

	var filtreCompteCle = $formulaireFiltres.find('.valeurCompteCle').val();
	if(filtreCompteCle != null && filtreCompteCle !== '')
		filtres.push({ name: 'fq', value: 'compteCle:' + filtreCompteCle });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreTransactionFrais = $formulaireFiltres.find('.valeurTransactionFrais').prop('checked');
	if(filtreTransactionFrais != null && filtreTransactionFrais === true)
		filtres.push({ name: 'fq', value: 'transactionFrais:' + filtreTransactionFrais });

	var filtreTransactionNomAffichage = $formulaireFiltres.find('.valeurTransactionNomAffichage').val();
	if(filtreTransactionNomAffichage != null && filtreTransactionNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'transactionNomAffichage:' + filtreTransactionNomAffichage });

	var filtreTransactionIdReference = $formulaireFiltres.find('.valeurTransactionIdReference').val();
	if(filtreTransactionIdReference != null && filtreTransactionIdReference !== '')
		filtres.push({ name: 'fq', value: 'transactionIdReference:' + filtreTransactionIdReference });

	var filtreTransactionMontant = $formulaireFiltres.find('.valeurTransactionMontant').val();
	if(filtreTransactionMontant != null && filtreTransactionMontant !== '')
		filtres.push({ name: 'fq', value: 'transactionMontant:' + filtreTransactionMontant });

	var filtreTransactionDateHeure = $formulaireFiltres.find('.valeurTransactionDateHeure').val();
	if(filtreTransactionDateHeure != null && filtreTransactionDateHeure !== '')
		filtres.push({ name: 'fq', value: 'transactionDateHeure:' + filtreTransactionDateHeure });

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

	var filtreTransactionCle = $formulaireFiltres.find('.valeurTransactionCle').val();
	if(filtreTransactionCle != null && filtreTransactionCle !== '')
		filtres.push({ name: 'fq', value: 'transactionCle:' + filtreTransactionCle });

	var filtreCompteNomComplet = $formulaireFiltres.find('.valeurCompteNomComplet').val();
	if(filtreCompteNomComplet != null && filtreCompteNomComplet !== '')
		filtres.push({ name: 'fq', value: 'compteNomComplet:' + filtreCompteNomComplet });

	var filtreCompteNumero = $formulaireFiltres.find('.valeurCompteNumero').val();
	if(filtreCompteNumero != null && filtreCompteNumero !== '')
		filtres.push({ name: 'fq', value: 'compteNumero:' + filtreCompteNumero });

	var filtreCodeTransactionNomComplet = $formulaireFiltres.find('.valeurCodeTransactionNomComplet').val();
	if(filtreCodeTransactionNomComplet != null && filtreCodeTransactionNomComplet !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomComplet:' + filtreCodeTransactionNomComplet });

	var filtreTransactionDate = $formulaireFiltres.find('.valeurTransactionDate').val();
	if(filtreTransactionDate != null && filtreTransactionDate !== '')
		filtres.push({ name: 'fq', value: 'transactionDate:' + filtreTransactionDate });

	var filtreTransactionNomComplet = $formulaireFiltres.find('.valeurTransactionNomComplet').val();
	if(filtreTransactionNomComplet != null && filtreTransactionNomComplet !== '')
		filtres.push({ name: 'fq', value: 'transactionNomComplet:' + filtreTransactionNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });
	return filtres;
}

function patchTransactionBancaireVal(filtres, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchTransactionBancaireVals(filtres, vals, success, error);
}

function patchTransactionBancaireVals(filtres, vals, success, error) {
	$.ajax({
		url: '/api/transaction?' + $.param(filtres)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

function getTransactionBancaire(pk) {
	$.ajax({
		url: '/api/transaction/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

function deleteTransactionBancaire(pk) {
	$.ajax({
		url: '/api/transaction/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Recherche //

function rechercheTransactionBancaire($formulaireFiltres, success, error) {
	var filtres = rechercheTransactionBancaireFiltres($formulaireFiltres);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	rechercheTransactionBancaireVals(filtres, success, error);
}

function rechercheTransactionBancaireFiltres($formulaireFiltres) {
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

	var filtreTransactionId = $formulaireFiltres.find('.valeurTransactionId').val();
	if(filtreTransactionId != null && filtreTransactionId !== '')
		filtres.push({ name: 'fq', value: 'transactionId:' + filtreTransactionId });

	var filtreCompteCle = $formulaireFiltres.find('.valeurCompteCle').val();
	if(filtreCompteCle != null && filtreCompteCle !== '')
		filtres.push({ name: 'fq', value: 'compteCle:' + filtreCompteCle });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreTransactionFrais = $formulaireFiltres.find('.valeurTransactionFrais').prop('checked');
	if(filtreTransactionFrais != null && filtreTransactionFrais === true)
		filtres.push({ name: 'fq', value: 'transactionFrais:' + filtreTransactionFrais });

	var filtreTransactionNomAffichage = $formulaireFiltres.find('.valeurTransactionNomAffichage').val();
	if(filtreTransactionNomAffichage != null && filtreTransactionNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'transactionNomAffichage:' + filtreTransactionNomAffichage });

	var filtreTransactionIdReference = $formulaireFiltres.find('.valeurTransactionIdReference').val();
	if(filtreTransactionIdReference != null && filtreTransactionIdReference !== '')
		filtres.push({ name: 'fq', value: 'transactionIdReference:' + filtreTransactionIdReference });

	var filtreTransactionMontant = $formulaireFiltres.find('.valeurTransactionMontant').val();
	if(filtreTransactionMontant != null && filtreTransactionMontant !== '')
		filtres.push({ name: 'fq', value: 'transactionMontant:' + filtreTransactionMontant });

	var filtreTransactionDateHeure = $formulaireFiltres.find('.valeurTransactionDateHeure').val();
	if(filtreTransactionDateHeure != null && filtreTransactionDateHeure !== '')
		filtres.push({ name: 'fq', value: 'transactionDateHeure:' + filtreTransactionDateHeure });

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

	var filtreTransactionCle = $formulaireFiltres.find('.valeurTransactionCle').val();
	if(filtreTransactionCle != null && filtreTransactionCle !== '')
		filtres.push({ name: 'fq', value: 'transactionCle:' + filtreTransactionCle });

	var filtreCompteNomComplet = $formulaireFiltres.find('.valeurCompteNomComplet').val();
	if(filtreCompteNomComplet != null && filtreCompteNomComplet !== '')
		filtres.push({ name: 'fq', value: 'compteNomComplet:' + filtreCompteNomComplet });

	var filtreCompteNumero = $formulaireFiltres.find('.valeurCompteNumero').val();
	if(filtreCompteNumero != null && filtreCompteNumero !== '')
		filtres.push({ name: 'fq', value: 'compteNumero:' + filtreCompteNumero });

	var filtreCodeTransactionNomComplet = $formulaireFiltres.find('.valeurCodeTransactionNomComplet').val();
	if(filtreCodeTransactionNomComplet != null && filtreCodeTransactionNomComplet !== '')
		filtres.push({ name: 'fq', value: 'codeTransactionNomComplet:' + filtreCodeTransactionNomComplet });

	var filtreTransactionDate = $formulaireFiltres.find('.valeurTransactionDate').val();
	if(filtreTransactionDate != null && filtreTransactionDate !== '')
		filtres.push({ name: 'fq', value: 'transactionDate:' + filtreTransactionDate });

	var filtreTransactionNomComplet = $formulaireFiltres.find('.valeurTransactionNomComplet').val();
	if(filtreTransactionNomComplet != null && filtreTransactionNomComplet !== '')
		filtres.push({ name: 'fq', value: 'transactionNomComplet:' + filtreTransactionNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });
	return filtres;
}

function rechercheTransactionBancaireVals(filtres, success, error) {
	$.ajax({
		url: '/api/transaction?' + $.param(filtres)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggereTransactionBancaireCompteCle($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fa fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['compteNomComplet']);
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			var pk = parseInt($('#TransactionBancaireForm :input[name="pk"]').val());
			var val = o['transactionCles'];
			var checked = Array.isArray(val) ? val.includes(pk) : val == pk;
			var $input = $('<input>');
			$input.attr('id', 'GET_compteCle_' + pk + '_transactionCles_' + o['pk']);
			$input.attr('class', 'w3-check ');
			$input.attr('onchange', "var $input = $('#GET_compteCle_" + pk + "_transactionCles_" + o['pk'] + "'); patchTransactionBancaireVals([{ name: 'fq', value: 'pk:" + pk + "' }], { [($input.prop('checked') ? 'set' : 'remove') + 'CompteCle']: \"" + o['pk'] + "\" }, function() { patchCompteBancaireVals([{ name: 'fq', value: 'pk:" + o['pk'] + "' }], {}, function() { ajouterLueur($input); }, function() { ajouterErreur($input); } ); } ); ");
			$input.attr('onclick', 'enleverLueur($(this)); ');
			$input.attr('type', 'checkbox');
			if(checked)
				$input.attr('checked', 'checked');
			var $li = $('<li>');
			$li.append($input);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercheCompteBancaire($formulaireFiltres, success, error);
}

function suggereTransactionBancaireObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['transactionNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherTransactionBancaireVals($formulaireFiltres, success, error);
}
