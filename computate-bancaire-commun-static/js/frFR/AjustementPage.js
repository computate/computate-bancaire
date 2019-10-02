
// POST //

function postAjustementBancaire($formulaireValeurs) {
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

	var valeurAjustementId = $formulaireValeurs.find('.valeurAjustementId').val();
	if(valeurAjustementId != null && valeurAjustementId !== '')
		vals['ajustementId'] = valeurAjustementId;

	var valeurCompteCle = $formulaireValeurs.find('.valeurCompteCle').val();
	if(valeurCompteCle != null && valeurCompteCle !== '')
		vals['compteCle'] = valeurCompteCle;

	var valeurTransactionCle = $formulaireValeurs.find('.valeurTransactionCle').val();
	if(valeurTransactionCle != null && valeurTransactionCle !== '')
		vals['transactionCle'] = valeurTransactionCle;

	var valeurAjustementNomAffichage = $formulaireValeurs.find('.valeurAjustementNomAffichage').val();
	if(valeurAjustementNomAffichage != null && valeurAjustementNomAffichage !== '')
		vals['ajustementNomAffichage'] = valeurAjustementNomAffichage;

	var valeurAgentZones = $formulaireValeurs.find('.valeurAgentZones').val();
	if(valeurAgentZones != null && valeurAgentZones !== '')
		vals['agentZones'] = valeurAgentZones;

	var valeurAgentRoles = $formulaireValeurs.find('.valeurAgentRoles').val();
	if(valeurAgentRoles != null && valeurAgentRoles !== '')
		vals['agentRoles'] = valeurAgentRoles;

	var valeurAgentPasserOutre = $formulaireValeurs.find('.valeurAgentPasserOutre').prop('checked');
	if(valeurAgentPasserOutre != null && valeurAgentPasserOutre !== '')
		vals['agentPasserOutre'] = valeurAgentPasserOutre;

	var valeurDroitEligible = $formulaireValeurs.find('.valeurDroitEligible').prop('checked');
	if(valeurDroitEligible != null && valeurDroitEligible !== '')
		vals['droitEligible'] = valeurDroitEligible;

	var valeurPartenaireNom = $formulaireValeurs.find('.valeurPartenaireNom').val();
	if(valeurPartenaireNom != null && valeurPartenaireNom !== '')
		vals['partenaireNom'] = valeurPartenaireNom;

	var valeurAjustementNomComplet = $formulaireValeurs.find('.valeurAjustementNomComplet').val();
	if(valeurAjustementNomComplet != null && valeurAjustementNomComplet !== '')
		vals['ajustementNomComplet'] = valeurAjustementNomComplet;

	$.ajax({
		url: '/api/ajustement'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postAjustementBancaireVals(vals, success, error) {
	$.ajax({
		url: '/api/ajustement'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

function patchAjustementBancaire($formulaireFiltres, $formulaireValeurs, success, error) {
	var filtres = patchAjustementBancaireFiltres($formulaireFiltres);

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

	var removeAjustementId = $formulaireFiltres.find('.removeAjustementId').val() === 'true';
	var setAjustementId = removeAjustementId ? null : $formulaireValeurs.find('.setAjustementId').val();
	if(removeAjustementId || setAjustementId != null && setAjustementId !== '')
		vals['setAjustementId'] = setAjustementId;
	var addAjustementId = $formulaireValeurs.find('.addAjustementId').val();
	if(addAjustementId != null && addAjustementId !== '')
		vals['addAjustementId'] = addAjustementId;
	var removeAjustementId = $formulaireValeurs.find('.removeAjustementId').val();
	if(removeAjustementId != null && removeAjustementId !== '')
		vals['removeAjustementId'] = removeAjustementId;

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

	var removeTransactionCle = $formulaireFiltres.find('.removeTransactionCle').val() === 'true';
	var setTransactionCle = removeTransactionCle ? null : $formulaireValeurs.find('.setTransactionCle').val();
	if(removeTransactionCle || setTransactionCle != null && setTransactionCle !== '')
		vals['setTransactionCle'] = setTransactionCle;
	var addTransactionCle = $formulaireValeurs.find('.addTransactionCle').val();
	if(addTransactionCle != null && addTransactionCle !== '')
		vals['addTransactionCle'] = addTransactionCle;
	var removeTransactionCle = $formulaireValeurs.find('.removeTransactionCle').val();
	if(removeTransactionCle != null && removeTransactionCle !== '')
		vals['removeTransactionCle'] = removeTransactionCle;

	var removeAjustementNomAffichage = $formulaireFiltres.find('.removeAjustementNomAffichage').val() === 'true';
	var setAjustementNomAffichage = removeAjustementNomAffichage ? null : $formulaireValeurs.find('.setAjustementNomAffichage').val();
	if(removeAjustementNomAffichage || setAjustementNomAffichage != null && setAjustementNomAffichage !== '')
		vals['setAjustementNomAffichage'] = setAjustementNomAffichage;
	var addAjustementNomAffichage = $formulaireValeurs.find('.addAjustementNomAffichage').val();
	if(addAjustementNomAffichage != null && addAjustementNomAffichage !== '')
		vals['addAjustementNomAffichage'] = addAjustementNomAffichage;
	var removeAjustementNomAffichage = $formulaireValeurs.find('.removeAjustementNomAffichage').val();
	if(removeAjustementNomAffichage != null && removeAjustementNomAffichage !== '')
		vals['removeAjustementNomAffichage'] = removeAjustementNomAffichage;

	var removeAgentZones = $formulaireFiltres.find('.removeAgentZones').val() === 'true';
	var setAgentZones = removeAgentZones ? null : $formulaireValeurs.find('.setAgentZones').val();
	if(removeAgentZones || setAgentZones != null && setAgentZones !== '')
		vals['setAgentZones'] = setAgentZones;
	var addAgentZones = $formulaireValeurs.find('.addAgentZones').val();
	if(addAgentZones != null && addAgentZones !== '')
		vals['addAgentZones'] = addAgentZones;
	var removeAgentZones = $formulaireValeurs.find('.removeAgentZones').val();
	if(removeAgentZones != null && removeAgentZones !== '')
		vals['removeAgentZones'] = removeAgentZones;

	var removeAgentRoles = $formulaireFiltres.find('.removeAgentRoles').val() === 'true';
	var setAgentRoles = removeAgentRoles ? null : $formulaireValeurs.find('.setAgentRoles').val();
	if(removeAgentRoles || setAgentRoles != null && setAgentRoles !== '')
		vals['setAgentRoles'] = setAgentRoles;
	var addAgentRoles = $formulaireValeurs.find('.addAgentRoles').val();
	if(addAgentRoles != null && addAgentRoles !== '')
		vals['addAgentRoles'] = addAgentRoles;
	var removeAgentRoles = $formulaireValeurs.find('.removeAgentRoles').val();
	if(removeAgentRoles != null && removeAgentRoles !== '')
		vals['removeAgentRoles'] = removeAgentRoles;

	var removeAgentPasserOutre = $formulaireFiltres.find('.removeAgentPasserOutre').val() === 'true';
	var setAgentPasserOutre = removeAgentPasserOutre ? null : $formulaireValeurs.find('.setAgentPasserOutre').prop('checked');
	if(removeAgentPasserOutre || setAgentPasserOutre != null && setAgentPasserOutre !== '')
		vals['setAgentPasserOutre'] = setAgentPasserOutre;
	var addAgentPasserOutre = $formulaireValeurs.find('.addAgentPasserOutre').prop('checked');
	if(addAgentPasserOutre != null && addAgentPasserOutre !== '')
		vals['addAgentPasserOutre'] = addAgentPasserOutre;
	var removeAgentPasserOutre = $formulaireValeurs.find('.removeAgentPasserOutre').prop('checked');
	if(removeAgentPasserOutre != null && removeAgentPasserOutre !== '')
		vals['removeAgentPasserOutre'] = removeAgentPasserOutre;

	var removeDroitEligible = $formulaireFiltres.find('.removeDroitEligible').val() === 'true';
	var setDroitEligible = removeDroitEligible ? null : $formulaireValeurs.find('.setDroitEligible').prop('checked');
	if(removeDroitEligible || setDroitEligible != null && setDroitEligible !== '')
		vals['setDroitEligible'] = setDroitEligible;
	var addDroitEligible = $formulaireValeurs.find('.addDroitEligible').prop('checked');
	if(addDroitEligible != null && addDroitEligible !== '')
		vals['addDroitEligible'] = addDroitEligible;
	var removeDroitEligible = $formulaireValeurs.find('.removeDroitEligible').prop('checked');
	if(removeDroitEligible != null && removeDroitEligible !== '')
		vals['removeDroitEligible'] = removeDroitEligible;

	var removePartenaireNom = $formulaireFiltres.find('.removePartenaireNom').val() === 'true';
	var setPartenaireNom = removePartenaireNom ? null : $formulaireValeurs.find('.setPartenaireNom').val();
	if(removePartenaireNom || setPartenaireNom != null && setPartenaireNom !== '')
		vals['setPartenaireNom'] = setPartenaireNom;
	var addPartenaireNom = $formulaireValeurs.find('.addPartenaireNom').val();
	if(addPartenaireNom != null && addPartenaireNom !== '')
		vals['addPartenaireNom'] = addPartenaireNom;
	var removePartenaireNom = $formulaireValeurs.find('.removePartenaireNom').val();
	if(removePartenaireNom != null && removePartenaireNom !== '')
		vals['removePartenaireNom'] = removePartenaireNom;

	var removeAjustementNomComplet = $formulaireFiltres.find('.removeAjustementNomComplet').val() === 'true';
	var setAjustementNomComplet = removeAjustementNomComplet ? null : $formulaireValeurs.find('.setAjustementNomComplet').val();
	if(removeAjustementNomComplet || setAjustementNomComplet != null && setAjustementNomComplet !== '')
		vals['setAjustementNomComplet'] = setAjustementNomComplet;
	var addAjustementNomComplet = $formulaireValeurs.find('.addAjustementNomComplet').val();
	if(addAjustementNomComplet != null && addAjustementNomComplet !== '')
		vals['addAjustementNomComplet'] = addAjustementNomComplet;
	var removeAjustementNomComplet = $formulaireValeurs.find('.removeAjustementNomComplet').val();
	if(removeAjustementNomComplet != null && removeAjustementNomComplet !== '')
		vals['removeAjustementNomComplet'] = removeAjustementNomComplet;

	patchAjustementBancaireVals(filtres, vals, success, error);
}

function patchAjustementBancaireFiltres($formulaireFiltres) {
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

	var filtreAjustementId = $formulaireFiltres.find('.valeurAjustementId').val();
	if(filtreAjustementId != null && filtreAjustementId !== '')
		filtres.push({ name: 'fq', value: 'ajustementId:' + filtreAjustementId });

	var filtreCompteCle = $formulaireFiltres.find('.valeurCompteCle').val();
	if(filtreCompteCle != null && filtreCompteCle !== '')
		filtres.push({ name: 'fq', value: 'compteCle:' + filtreCompteCle });

	var filtreTransactionCle = $formulaireFiltres.find('.valeurTransactionCle').val();
	if(filtreTransactionCle != null && filtreTransactionCle !== '')
		filtres.push({ name: 'fq', value: 'transactionCle:' + filtreTransactionCle });

	var filtreAjustementNomAffichage = $formulaireFiltres.find('.valeurAjustementNomAffichage').val();
	if(filtreAjustementNomAffichage != null && filtreAjustementNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'ajustementNomAffichage:' + filtreAjustementNomAffichage });

	var filtreAgentZones = $formulaireFiltres.find('.valeurAgentZones').val();
	if(filtreAgentZones != null && filtreAgentZones !== '')
		filtres.push({ name: 'fq', value: 'agentZones:' + filtreAgentZones });

	var filtreAgentRoles = $formulaireFiltres.find('.valeurAgentRoles').val();
	if(filtreAgentRoles != null && filtreAgentRoles !== '')
		filtres.push({ name: 'fq', value: 'agentRoles:' + filtreAgentRoles });

	var filtreAgentPasserOutre = $formulaireFiltres.find('.valeurAgentPasserOutre').prop('checked');
	if(filtreAgentPasserOutre != null && filtreAgentPasserOutre === true)
		filtres.push({ name: 'fq', value: 'agentPasserOutre:' + filtreAgentPasserOutre });

	var filtreDroitEligible = $formulaireFiltres.find('.valeurDroitEligible').prop('checked');
	if(filtreDroitEligible != null && filtreDroitEligible === true)
		filtres.push({ name: 'fq', value: 'droitEligible:' + filtreDroitEligible });

	var filtrePartenaireNom = $formulaireFiltres.find('.valeurPartenaireNom').val();
	if(filtrePartenaireNom != null && filtrePartenaireNom !== '')
		filtres.push({ name: 'fq', value: 'partenaireNom:' + filtrePartenaireNom });

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

	var filtreAjustementCle = $formulaireFiltres.find('.valeurAjustementCle').val();
	if(filtreAjustementCle != null && filtreAjustementCle !== '')
		filtres.push({ name: 'fq', value: 'ajustementCle:' + filtreAjustementCle });

	var filtreCompteNomComplet = $formulaireFiltres.find('.valeurCompteNomComplet').val();
	if(filtreCompteNomComplet != null && filtreCompteNomComplet !== '')
		filtres.push({ name: 'fq', value: 'compteNomComplet:' + filtreCompteNomComplet });

	var filtreCompteNumero = $formulaireFiltres.find('.valeurCompteNumero').val();
	if(filtreCompteNumero != null && filtreCompteNumero !== '')
		filtres.push({ name: 'fq', value: 'compteNumero:' + filtreCompteNumero });

	var filtreTransactionIdReference = $formulaireFiltres.find('.valeurTransactionIdReference').val();
	if(filtreTransactionIdReference != null && filtreTransactionIdReference !== '')
		filtres.push({ name: 'fq', value: 'transactionIdReference:' + filtreTransactionIdReference });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreTransactionMontant = $formulaireFiltres.find('.valeurTransactionMontant').val();
	if(filtreTransactionMontant != null && filtreTransactionMontant !== '')
		filtres.push({ name: 'fq', value: 'transactionMontant:' + filtreTransactionMontant });

	var filtreTransactionDateHeure = $formulaireFiltres.find('.valeurTransactionDateHeure').val();
	if(filtreTransactionDateHeure != null && filtreTransactionDateHeure !== '')
		filtres.push({ name: 'fq', value: 'transactionDateHeure:' + filtreTransactionDateHeure });

	var filtreTransactionDate = $formulaireFiltres.find('.valeurTransactionDate').val();
	if(filtreTransactionDate != null && filtreTransactionDate !== '')
		filtres.push({ name: 'fq', value: 'transactionDate:' + filtreTransactionDate });

	var filtreTransactionFrais = $formulaireFiltres.find('.valeurTransactionFrais').prop('checked');
	if(filtreTransactionFrais != null && filtreTransactionFrais === true)
		filtres.push({ name: 'fq', value: 'transactionFrais:' + filtreTransactionFrais });

	var filtreAjustementNomComplet = $formulaireFiltres.find('.valeurAjustementNomComplet').val();
	if(filtreAjustementNomComplet != null && filtreAjustementNomComplet !== '')
		filtres.push({ name: 'fq', value: 'ajustementNomComplet:' + filtreAjustementNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });
	return filtres;
}

function patchAjustementBancaireVal(filtres, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchAjustementBancaireVals(filtres, vals, success, error);
}

function patchAjustementBancaireVals(filtres, vals, success, error) {
	$.ajax({
		url: '/api/ajustement?' + $.param(filtres)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

function getAjustementBancaire(pk) {
	$.ajax({
		url: '/api/ajustement/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

function deleteAjustementBancaire(pk) {
	$.ajax({
		url: '/api/ajustement/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Recherche //

function rechercheAjustementBancaire($formulaireFiltres, success, error) {
	var filtres = rechercheAjustementBancaireFiltres($formulaireFiltres);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	rechercheAjustementBancaireVals(filtres, success, error);
}

function rechercheAjustementBancaireFiltres($formulaireFiltres) {
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

	var filtreAjustementId = $formulaireFiltres.find('.valeurAjustementId').val();
	if(filtreAjustementId != null && filtreAjustementId !== '')
		filtres.push({ name: 'fq', value: 'ajustementId:' + filtreAjustementId });

	var filtreCompteCle = $formulaireFiltres.find('.valeurCompteCle').val();
	if(filtreCompteCle != null && filtreCompteCle !== '')
		filtres.push({ name: 'fq', value: 'compteCle:' + filtreCompteCle });

	var filtreTransactionCle = $formulaireFiltres.find('.valeurTransactionCle').val();
	if(filtreTransactionCle != null && filtreTransactionCle !== '')
		filtres.push({ name: 'fq', value: 'transactionCle:' + filtreTransactionCle });

	var filtreAjustementNomAffichage = $formulaireFiltres.find('.valeurAjustementNomAffichage').val();
	if(filtreAjustementNomAffichage != null && filtreAjustementNomAffichage !== '')
		filtres.push({ name: 'fq', value: 'ajustementNomAffichage:' + filtreAjustementNomAffichage });

	var filtreAgentZones = $formulaireFiltres.find('.valeurAgentZones').val();
	if(filtreAgentZones != null && filtreAgentZones !== '')
		filtres.push({ name: 'fq', value: 'agentZones:' + filtreAgentZones });

	var filtreAgentRoles = $formulaireFiltres.find('.valeurAgentRoles').val();
	if(filtreAgentRoles != null && filtreAgentRoles !== '')
		filtres.push({ name: 'fq', value: 'agentRoles:' + filtreAgentRoles });

	var filtreAgentPasserOutre = $formulaireFiltres.find('.valeurAgentPasserOutre').prop('checked');
	if(filtreAgentPasserOutre != null && filtreAgentPasserOutre === true)
		filtres.push({ name: 'fq', value: 'agentPasserOutre:' + filtreAgentPasserOutre });

	var filtreDroitEligible = $formulaireFiltres.find('.valeurDroitEligible').prop('checked');
	if(filtreDroitEligible != null && filtreDroitEligible === true)
		filtres.push({ name: 'fq', value: 'droitEligible:' + filtreDroitEligible });

	var filtrePartenaireNom = $formulaireFiltres.find('.valeurPartenaireNom').val();
	if(filtrePartenaireNom != null && filtrePartenaireNom !== '')
		filtres.push({ name: 'fq', value: 'partenaireNom:' + filtrePartenaireNom });

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

	var filtreAjustementCle = $formulaireFiltres.find('.valeurAjustementCle').val();
	if(filtreAjustementCle != null && filtreAjustementCle !== '')
		filtres.push({ name: 'fq', value: 'ajustementCle:' + filtreAjustementCle });

	var filtreCompteNomComplet = $formulaireFiltres.find('.valeurCompteNomComplet').val();
	if(filtreCompteNomComplet != null && filtreCompteNomComplet !== '')
		filtres.push({ name: 'fq', value: 'compteNomComplet:' + filtreCompteNomComplet });

	var filtreCompteNumero = $formulaireFiltres.find('.valeurCompteNumero').val();
	if(filtreCompteNumero != null && filtreCompteNumero !== '')
		filtres.push({ name: 'fq', value: 'compteNumero:' + filtreCompteNumero });

	var filtreTransactionIdReference = $formulaireFiltres.find('.valeurTransactionIdReference').val();
	if(filtreTransactionIdReference != null && filtreTransactionIdReference !== '')
		filtres.push({ name: 'fq', value: 'transactionIdReference:' + filtreTransactionIdReference });

	var filtreTransactionCode = $formulaireFiltres.find('.valeurTransactionCode').val();
	if(filtreTransactionCode != null && filtreTransactionCode !== '')
		filtres.push({ name: 'fq', value: 'transactionCode:' + filtreTransactionCode });

	var filtreTransactionMontant = $formulaireFiltres.find('.valeurTransactionMontant').val();
	if(filtreTransactionMontant != null && filtreTransactionMontant !== '')
		filtres.push({ name: 'fq', value: 'transactionMontant:' + filtreTransactionMontant });

	var filtreTransactionDateHeure = $formulaireFiltres.find('.valeurTransactionDateHeure').val();
	if(filtreTransactionDateHeure != null && filtreTransactionDateHeure !== '')
		filtres.push({ name: 'fq', value: 'transactionDateHeure:' + filtreTransactionDateHeure });

	var filtreTransactionDate = $formulaireFiltres.find('.valeurTransactionDate').val();
	if(filtreTransactionDate != null && filtreTransactionDate !== '')
		filtres.push({ name: 'fq', value: 'transactionDate:' + filtreTransactionDate });

	var filtreTransactionFrais = $formulaireFiltres.find('.valeurTransactionFrais').prop('checked');
	if(filtreTransactionFrais != null && filtreTransactionFrais === true)
		filtres.push({ name: 'fq', value: 'transactionFrais:' + filtreTransactionFrais });

	var filtreAjustementNomComplet = $formulaireFiltres.find('.valeurAjustementNomComplet').val();
	if(filtreAjustementNomComplet != null && filtreAjustementNomComplet !== '')
		filtres.push({ name: 'fq', value: 'ajustementNomComplet:' + filtreAjustementNomComplet });

	var filtrePageUrl = $formulaireFiltres.find('.valeurPageUrl').val();
	if(filtrePageUrl != null && filtrePageUrl !== '')
		filtres.push({ name: 'fq', value: 'pageUrl:' + filtrePageUrl });

	var filtreObjetSuggere = $formulaireFiltres.find('.valeurObjetSuggere').val();
	if(filtreObjetSuggere != null && filtreObjetSuggere !== '')
		filtres.push({ name: 'q', value: 'objetSuggere:' + filtreObjetSuggere });
	return filtres;
}

function rechercheAjustementBancaireVals(filtres, success, error) {
	$.ajax({
		url: '/api/ajustement?' + $.param(filtres)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggereAjustementBancaireObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['ajustementNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherAjustementBancaireVals($formulaireFiltres, success, error);
}
