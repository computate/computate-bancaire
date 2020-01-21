
// POST //

async function postCompteBancaire($formulaireValeurs, success, error) {
	var vals = {};
	if(success == null) {
		success = function( data, textStatus, jQxhr ) {
			ajouterLueur($formulaireValeurs.next('button'));
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

	var valeurCompteId = $formulaireValeurs.find('.valeurCompteId').val();
	if(valeurCompteId != null && valeurCompteId !== '')
		vals['compteId'] = valeurCompteId;

	var valeurArchive = $formulaireValeurs.find('.valeurArchive').prop('checked');
	if(valeurArchive != null && valeurArchive !== '')
		vals['archive'] = valeurArchive;

	var valeurSupprime = $formulaireValeurs.find('.valeurSupprime').prop('checked');
	if(valeurSupprime != null && valeurSupprime !== '')
		vals['supprime'] = valeurSupprime;

	var valeurTransactionCles = $formulaireValeurs.find('.valeurTransactionCles').val();
	if(valeurTransactionCles != null && valeurTransactionCles !== '')
		vals['transactionCles'] = valeurTransactionCles;

	var valeurCompteNumero = $formulaireValeurs.find('.valeurCompteNumero').val();
	if(valeurCompteNumero != null && valeurCompteNumero !== '')
		vals['compteNumero'] = valeurCompteNumero;

	var valeurCompteAdministrateurNom = $formulaireValeurs.find('.valeurCompteAdministrateurNom').val();
	if(valeurCompteAdministrateurNom != null && valeurCompteAdministrateurNom !== '')
		vals['compteAdministrateurNom'] = valeurCompteAdministrateurNom;

	var valeurCompteEmplacement = $formulaireValeurs.find('.valeurCompteEmplacement').val();
	if(valeurCompteEmplacement != null && valeurCompteEmplacement !== '')
		vals['compteEmplacement'] = valeurCompteEmplacement;

	var valeurCompteNumeroTelephone = $formulaireValeurs.find('.valeurCompteNumeroTelephone').val();
	if(valeurCompteNumeroTelephone != null && valeurCompteNumeroTelephone !== '')
		vals['compteNumeroTelephone'] = valeurCompteNumeroTelephone;

	var valeurCompteAddresse = $formulaireValeurs.find('.valeurCompteAddresse').val();
	if(valeurCompteAddresse != null && valeurCompteAddresse !== '')
		vals['compteAddresse'] = valeurCompteAddresse;

	var valeurCompteNomComplet = $formulaireValeurs.find('.valeurCompteNomComplet').val();
	if(valeurCompteNomComplet != null && valeurCompteNomComplet !== '')
		vals['compteNomComplet'] = valeurCompteNomComplet;

	$.ajax({
		url: '/api/compte'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postCompteBancaireVals(vals, success, error) {
	$.ajax({
		url: '/api/compte'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchCompteBancaire($formulaireFiltres, $formulaireValeurs, success, error) {
	var filtres = patchCompteBancaireFiltres($formulaireFiltres);

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

	var removeCompteId = $formulaireFiltres.find('.removeCompteId').val() === 'true';
	var setCompteId = removeCompteId ? null : $formulaireValeurs.find('.setCompteId').val();
	if(removeCompteId || setCompteId != null && setCompteId !== '')
		vals['setCompteId'] = setCompteId;
	var addCompteId = $formulaireValeurs.find('.addCompteId').val();
	if(addCompteId != null && addCompteId !== '')
		vals['addCompteId'] = addCompteId;
	var removeCompteId = $formulaireValeurs.find('.removeCompteId').val();
	if(removeCompteId != null && removeCompteId !== '')
		vals['removeCompteId'] = removeCompteId;

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

	var removeTransactionCles = $formulaireFiltres.find('.removeTransactionCles').val() === 'true';
	var setTransactionCles = removeTransactionCles ? null : $formulaireValeurs.find('.setTransactionCles').val();
	if(removeTransactionCles || setTransactionCles != null && setTransactionCles !== '')
		vals['setTransactionCles'] = setTransactionCles;
	var addTransactionCles = $formulaireValeurs.find('.addTransactionCles').val();
	if(addTransactionCles != null && addTransactionCles !== '')
		vals['addTransactionCles'] = addTransactionCles;
	var removeTransactionCles = $formulaireValeurs.find('.removeTransactionCles').val();
	if(removeTransactionCles != null && removeTransactionCles !== '')
		vals['removeTransactionCles'] = removeTransactionCles;

	var removeCompteNumero = $formulaireFiltres.find('.removeCompteNumero').val() === 'true';
	var setCompteNumero = removeCompteNumero ? null : $formulaireValeurs.find('.setCompteNumero').val();
	if(removeCompteNumero || setCompteNumero != null && setCompteNumero !== '')
		vals['setCompteNumero'] = setCompteNumero;
	var addCompteNumero = $formulaireValeurs.find('.addCompteNumero').val();
	if(addCompteNumero != null && addCompteNumero !== '')
		vals['addCompteNumero'] = addCompteNumero;
	var removeCompteNumero = $formulaireValeurs.find('.removeCompteNumero').val();
	if(removeCompteNumero != null && removeCompteNumero !== '')
		vals['removeCompteNumero'] = removeCompteNumero;

	var removeCompteAdministrateurNom = $formulaireFiltres.find('.removeCompteAdministrateurNom').val() === 'true';
	var setCompteAdministrateurNom = removeCompteAdministrateurNom ? null : $formulaireValeurs.find('.setCompteAdministrateurNom').val();
	if(removeCompteAdministrateurNom || setCompteAdministrateurNom != null && setCompteAdministrateurNom !== '')
		vals['setCompteAdministrateurNom'] = setCompteAdministrateurNom;
	var addCompteAdministrateurNom = $formulaireValeurs.find('.addCompteAdministrateurNom').val();
	if(addCompteAdministrateurNom != null && addCompteAdministrateurNom !== '')
		vals['addCompteAdministrateurNom'] = addCompteAdministrateurNom;
	var removeCompteAdministrateurNom = $formulaireValeurs.find('.removeCompteAdministrateurNom').val();
	if(removeCompteAdministrateurNom != null && removeCompteAdministrateurNom !== '')
		vals['removeCompteAdministrateurNom'] = removeCompteAdministrateurNom;

	var removeCompteEmplacement = $formulaireFiltres.find('.removeCompteEmplacement').val() === 'true';
	var setCompteEmplacement = removeCompteEmplacement ? null : $formulaireValeurs.find('.setCompteEmplacement').val();
	if(removeCompteEmplacement || setCompteEmplacement != null && setCompteEmplacement !== '')
		vals['setCompteEmplacement'] = setCompteEmplacement;
	var addCompteEmplacement = $formulaireValeurs.find('.addCompteEmplacement').val();
	if(addCompteEmplacement != null && addCompteEmplacement !== '')
		vals['addCompteEmplacement'] = addCompteEmplacement;
	var removeCompteEmplacement = $formulaireValeurs.find('.removeCompteEmplacement').val();
	if(removeCompteEmplacement != null && removeCompteEmplacement !== '')
		vals['removeCompteEmplacement'] = removeCompteEmplacement;

	var removeCompteNumeroTelephone = $formulaireFiltres.find('.removeCompteNumeroTelephone').val() === 'true';
	var setCompteNumeroTelephone = removeCompteNumeroTelephone ? null : $formulaireValeurs.find('.setCompteNumeroTelephone').val();
	if(removeCompteNumeroTelephone || setCompteNumeroTelephone != null && setCompteNumeroTelephone !== '')
		vals['setCompteNumeroTelephone'] = setCompteNumeroTelephone;
	var addCompteNumeroTelephone = $formulaireValeurs.find('.addCompteNumeroTelephone').val();
	if(addCompteNumeroTelephone != null && addCompteNumeroTelephone !== '')
		vals['addCompteNumeroTelephone'] = addCompteNumeroTelephone;
	var removeCompteNumeroTelephone = $formulaireValeurs.find('.removeCompteNumeroTelephone').val();
	if(removeCompteNumeroTelephone != null && removeCompteNumeroTelephone !== '')
		vals['removeCompteNumeroTelephone'] = removeCompteNumeroTelephone;

	var removeCompteAddresse = $formulaireFiltres.find('.removeCompteAddresse').val() === 'true';
	var setCompteAddresse = removeCompteAddresse ? null : $formulaireValeurs.find('.setCompteAddresse').val();
	if(removeCompteAddresse || setCompteAddresse != null && setCompteAddresse !== '')
		vals['setCompteAddresse'] = setCompteAddresse;
	var addCompteAddresse = $formulaireValeurs.find('.addCompteAddresse').val();
	if(addCompteAddresse != null && addCompteAddresse !== '')
		vals['addCompteAddresse'] = addCompteAddresse;
	var removeCompteAddresse = $formulaireValeurs.find('.removeCompteAddresse').val();
	if(removeCompteAddresse != null && removeCompteAddresse !== '')
		vals['removeCompteAddresse'] = removeCompteAddresse;

	var removeCompteNomComplet = $formulaireFiltres.find('.removeCompteNomComplet').val() === 'true';
	var setCompteNomComplet = removeCompteNomComplet ? null : $formulaireValeurs.find('.setCompteNomComplet').val();
	if(removeCompteNomComplet || setCompteNomComplet != null && setCompteNomComplet !== '')
		vals['setCompteNomComplet'] = setCompteNomComplet;
	var addCompteNomComplet = $formulaireValeurs.find('.addCompteNomComplet').val();
	if(addCompteNomComplet != null && addCompteNomComplet !== '')
		vals['addCompteNomComplet'] = addCompteNomComplet;
	var removeCompteNomComplet = $formulaireValeurs.find('.removeCompteNomComplet').val();
	if(removeCompteNomComplet != null && removeCompteNomComplet !== '')
		vals['removeCompteNomComplet'] = removeCompteNomComplet;

	patchCompteBancaireVals(filtres, vals, success, error);
}

function patchCompteBancaireFiltres($formulaireFiltres) {
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

	var filtreCompteId = $formulaireFiltres.find('.valeurCompteId').val();
	if(filtreCompteId != null && filtreCompteId !== '')
		filtres.push({ name: 'fq', value: 'compteId:' + filtreCompteId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreTransactionCles = $formulaireFiltres.find('.valeurTransactionCles').val();
	if(filtreTransactionCles != null && filtreTransactionCles !== '')
		filtres.push({ name: 'fq', value: 'transactionCles:' + filtreTransactionCles });

	var filtreCompteNumero = $formulaireFiltres.find('.valeurCompteNumero').val();
	if(filtreCompteNumero != null && filtreCompteNumero !== '')
		filtres.push({ name: 'fq', value: 'compteNumero:' + filtreCompteNumero });

	var filtreCompteAdministrateurNom = $formulaireFiltres.find('.valeurCompteAdministrateurNom').val();
	if(filtreCompteAdministrateurNom != null && filtreCompteAdministrateurNom !== '')
		filtres.push({ name: 'fq', value: 'compteAdministrateurNom:' + filtreCompteAdministrateurNom });

	var filtreCompteEmplacement = $formulaireFiltres.find('.valeurCompteEmplacement').val();
	if(filtreCompteEmplacement != null && filtreCompteEmplacement !== '')
		filtres.push({ name: 'fq', value: 'compteEmplacement:' + filtreCompteEmplacement });

	var filtreCompteNumeroTelephone = $formulaireFiltres.find('.valeurCompteNumeroTelephone').val();
	if(filtreCompteNumeroTelephone != null && filtreCompteNumeroTelephone !== '')
		filtres.push({ name: 'fq', value: 'compteNumeroTelephone:' + filtreCompteNumeroTelephone });

	var filtreCompteAddresse = $formulaireFiltres.find('.valeurCompteAddresse').val();
	if(filtreCompteAddresse != null && filtreCompteAddresse !== '')
		filtres.push({ name: 'fq', value: 'compteAddresse:' + filtreCompteAddresse });

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

	var filtreObjetTitre = $formulaireFiltres.find('.valeurObjetTitre').val();
	if(filtreObjetTitre != null && filtreObjetTitre !== '')
		filtres.push({ name: 'fq', value: 'objetTitre:' + filtreObjetTitre });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreCompteCle = $formulaireFiltres.find('.valeurCompteCle').val();
	if(filtreCompteCle != null && filtreCompteCle !== '')
		filtres.push({ name: 'fq', value: 'compteCle:' + filtreCompteCle });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });

	var filtreCompteNumeroCourt = $formulaireFiltres.find('.valeurCompteNumeroCourt').val();
	if(filtreCompteNumeroCourt != null && filtreCompteNumeroCourt !== '')
		filtres.push({ name: 'fq', value: 'compteNumeroCourt:' + filtreCompteNumeroCourt });

	var filtreCompteNomComplet = $formulaireFiltres.find('.valeurCompteNomComplet').val();
	if(filtreCompteNomComplet != null && filtreCompteNomComplet !== '')
		filtres.push({ name: 'fq', value: 'compteNomComplet:' + filtreCompteNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });
	return filtres;
}

function patchCompteBancaireVal(filtres, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchCompteBancaireVals(filtres, vals, success, error);
}

function patchCompteBancaireVals(filtres, vals, success, error) {
	$.ajax({
		url: '/api/compte?' + $.param(filtres)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getCompteBancaire(pk) {
	$.ajax({
		url: '/api/compte/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteCompteBancaire(pk) {
	$.ajax({
		url: '/api/compte/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Recherche //

async function rechercheCompteBancaire($formulaireFiltres, success, error) {
	var filtres = rechercheCompteBancaireFiltres($formulaireFiltres);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	rechercheCompteBancaireVals(filtres, success, error);
}

function rechercheCompteBancaireFiltres($formulaireFiltres) {
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

	var filtreCompteId = $formulaireFiltres.find('.valeurCompteId').val();
	if(filtreCompteId != null && filtreCompteId !== '')
		filtres.push({ name: 'fq', value: 'compteId:' + filtreCompteId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreTransactionCles = $formulaireFiltres.find('.valeurTransactionCles').val();
	if(filtreTransactionCles != null && filtreTransactionCles !== '')
		filtres.push({ name: 'fq', value: 'transactionCles:' + filtreTransactionCles });

	var filtreCompteNumero = $formulaireFiltres.find('.valeurCompteNumero').val();
	if(filtreCompteNumero != null && filtreCompteNumero !== '')
		filtres.push({ name: 'fq', value: 'compteNumero:' + filtreCompteNumero });

	var filtreCompteAdministrateurNom = $formulaireFiltres.find('.valeurCompteAdministrateurNom').val();
	if(filtreCompteAdministrateurNom != null && filtreCompteAdministrateurNom !== '')
		filtres.push({ name: 'fq', value: 'compteAdministrateurNom:' + filtreCompteAdministrateurNom });

	var filtreCompteEmplacement = $formulaireFiltres.find('.valeurCompteEmplacement').val();
	if(filtreCompteEmplacement != null && filtreCompteEmplacement !== '')
		filtres.push({ name: 'fq', value: 'compteEmplacement:' + filtreCompteEmplacement });

	var filtreCompteNumeroTelephone = $formulaireFiltres.find('.valeurCompteNumeroTelephone').val();
	if(filtreCompteNumeroTelephone != null && filtreCompteNumeroTelephone !== '')
		filtres.push({ name: 'fq', value: 'compteNumeroTelephone:' + filtreCompteNumeroTelephone });

	var filtreCompteAddresse = $formulaireFiltres.find('.valeurCompteAddresse').val();
	if(filtreCompteAddresse != null && filtreCompteAddresse !== '')
		filtres.push({ name: 'fq', value: 'compteAddresse:' + filtreCompteAddresse });

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

	var filtreObjetTitre = $formulaireFiltres.find('.valeurObjetTitre').val();
	if(filtreObjetTitre != null && filtreObjetTitre !== '')
		filtres.push({ name: 'fq', value: 'objetTitre:' + filtreObjetTitre });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreCompteCle = $formulaireFiltres.find('.valeurCompteCle').val();
	if(filtreCompteCle != null && filtreCompteCle !== '')
		filtres.push({ name: 'fq', value: 'compteCle:' + filtreCompteCle });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });

	var filtreCompteNumeroCourt = $formulaireFiltres.find('.valeurCompteNumeroCourt').val();
	if(filtreCompteNumeroCourt != null && filtreCompteNumeroCourt !== '')
		filtres.push({ name: 'fq', value: 'compteNumeroCourt:' + filtreCompteNumeroCourt });

	var filtreCompteNomComplet = $formulaireFiltres.find('.valeurCompteNomComplet').val();
	if(filtreCompteNomComplet != null && filtreCompteNomComplet !== '')
		filtres.push({ name: 'fq', value: 'compteNomComplet:' + filtreCompteNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });
	return filtres;
}

function rechercheCompteBancaireVals(filtres, success, error) {
	$.ajax({
		url: '/api/compte?' + $.param(filtres)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggereCompteBancaireObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['compteNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherCompteBancaireVals($formulaireFiltres, success, error);
}

function suggereCompteBancaireObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['compteNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherCompteBancaireVals($formulaireFiltres, success, error);
}

async function websocketCompteBancaire(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketCompteBancaire', function (error, message) {
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
				var $header = $('<div>').attr('class', 'w3-container fa-gray ').attr('id', 'header-' + id);
				var $i = $('<i>').attr('class', 'fad fa-money-check w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modifier comptes');
				var $x = $('<span>').attr('class', 'w3-button w3-display-topright ').attr('onclick', '$("#card-' + id + '").hide(); ').attr('id', 'x-' + id);
				var $body = $('<div>').attr('class', 'w3-container w3-padding ').attr('id', 'text-' + id);
				var $bar = $('<div>').attr('class', 'w3-light-gray ').attr('id', 'bar-' + id);
				var $progress = $('<div>').attr('class', 'w3-gray ').attr('style', 'height: 24px; width: ' + percent + '; ').attr('id', 'progress-' + id).text(numPATCH + '/' + numFound);
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
async function websocketCompteBancaireInner(requetePatch) {
	var pk = requetePatch['pk'];
	var pks = requetePatch['pks'];
	var classes = requetePatch['classes'];
	var vars = requetePatch['vars'];
	var empty = requetePatch['empty'];

	if(pk != null) {
		rechercherCompteBancaireVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('cree')) {
				$('.inputCompteBancaire' + pk + 'Cree').val(o['cree']);
				$('.varCompteBancaire' + pk + 'Cree').text(o['cree']);
			}
			if(vars.includes('modifie')) {
				$('.inputCompteBancaire' + pk + 'Modifie').val(o['modifie']);
				$('.varCompteBancaire' + pk + 'Modifie').text(o['modifie']);
			}
			if(vars.includes('archive')) {
				$('.inputCompteBancaire' + pk + 'Archive').val(o['archive']);
				$('.varCompteBancaire' + pk + 'Archive').text(o['archive']);
			}
			if(vars.includes('supprime')) {
				$('.inputCompteBancaire' + pk + 'Supprime').val(o['supprime']);
				$('.varCompteBancaire' + pk + 'Supprime').text(o['supprime']);
			}
			if(vars.includes('compteNumero')) {
				$('.inputCompteBancaire' + pk + 'CompteNumero').val(o['compteNumero']);
				$('.varCompteBancaire' + pk + 'CompteNumero').text(o['compteNumero']);
			}
			if(vars.includes('compteAdministrateurNom')) {
				$('.inputCompteBancaire' + pk + 'CompteAdministrateurNom').val(o['compteAdministrateurNom']);
				$('.varCompteBancaire' + pk + 'CompteAdministrateurNom').text(o['compteAdministrateurNom']);
			}
			if(vars.includes('compteEmplacement')) {
				$('.inputCompteBancaire' + pk + 'CompteEmplacement').val(o['compteEmplacement']);
				$('.varCompteBancaire' + pk + 'CompteEmplacement').text(o['compteEmplacement']);
			}
			if(vars.includes('compteNumeroTelephone')) {
				$('.inputCompteBancaire' + pk + 'CompteNumeroTelephone').val(o['compteNumeroTelephone']);
				$('.varCompteBancaire' + pk + 'CompteNumeroTelephone').text(o['compteNumeroTelephone']);
			}
			if(vars.includes('compteAddresse')) {
				$('.inputCompteBancaire' + pk + 'CompteAddresse').val(o['compteAddresse']);
				$('.varCompteBancaire' + pk + 'CompteAddresse').text(o['compteAddresse']);
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
		await patchCompteBancaireVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
