
// POST //

async function postAjustementBancaire($formulaireValeurs, success, error) {
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

	var valeurAjustementId = $formulaireValeurs.find('.valeurAjustementId').val();
	if(valeurAjustementId != null && valeurAjustementId !== '')
		vals['ajustementId'] = valeurAjustementId;

	var valeurArchive = $formulaireValeurs.find('.valeurArchive').prop('checked');
	if(valeurArchive != null && valeurArchive !== '')
		vals['archive'] = valeurArchive;

	var valeurSupprime = $formulaireValeurs.find('.valeurSupprime').prop('checked');
	if(valeurSupprime != null && valeurSupprime !== '')
		vals['supprime'] = valeurSupprime;

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

async function patchAjustementBancaire($formulaireFiltres, $formulaireValeurs, success, error) {
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

	var filtreObjetId = $formulaireFiltres.find('.valeurObjetId').val();
	if(filtreObjetId != null && filtreObjetId !== '')
		filtres.push({ name: 'fq', value: 'objetId:' + filtreObjetId });

	var filtreAjustementId = $formulaireFiltres.find('.valeurAjustementId').val();
	if(filtreAjustementId != null && filtreAjustementId !== '')
		filtres.push({ name: 'fq', value: 'ajustementId:' + filtreAjustementId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

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

async function getAjustementBancaire(pk) {
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

async function deleteAjustementBancaire(pk) {
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

async function rechercheAjustementBancaire($formulaireFiltres, success, error) {
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

	var filtreObjetId = $formulaireFiltres.find('.valeurObjetId').val();
	if(filtreObjetId != null && filtreObjetId !== '')
		filtres.push({ name: 'fq', value: 'objetId:' + filtreObjetId });

	var filtreAjustementId = $formulaireFiltres.find('.valeurAjustementId').val();
	if(filtreAjustementId != null && filtreAjustementId !== '')
		filtres.push({ name: 'fq', value: 'ajustementId:' + filtreAjustementId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

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
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherAjustementBancaireVals($formulaireFiltres, success, error);
}

function suggereAjustementBancaireObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['ajustementNomComplet']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherAjustementBancaireVals($formulaireFiltres, success, error);
}

async function websocketAjustementBancaire(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketAjustementBancaire', function (error, message) {
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
				var $i = $('<i>').attr('class', 'fad fa-cash-register w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modifier ajustements');
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
async function websocketAjustementBancaireInner(requetePatch) {
	var pk = requetePatch['pk'];
	var pks = requetePatch['pks'];
	var classes = requetePatch['classes'];
	var vars = requetePatch['vars'];
	var empty = requetePatch['empty'];

	if(pk != null) {
		rechercherAjustementBancaireVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('cree')) {
				$('.inputAjustementBancaire' + pk + 'Cree').val(o['cree']);
				$('.varAjustementBancaire' + pk + 'Cree').text(o['cree']);
			}
			if(vars.includes('modifie')) {
				$('.inputAjustementBancaire' + pk + 'Modifie').val(o['modifie']);
				$('.varAjustementBancaire' + pk + 'Modifie').text(o['modifie']);
			}
			if(vars.includes('archive')) {
				$('.inputAjustementBancaire' + pk + 'Archive').val(o['archive']);
				$('.varAjustementBancaire' + pk + 'Archive').text(o['archive']);
			}
			if(vars.includes('supprime')) {
				$('.inputAjustementBancaire' + pk + 'Supprime').val(o['supprime']);
				$('.varAjustementBancaire' + pk + 'Supprime').text(o['supprime']);
			}
			if(vars.includes('ajustementNomAffichage')) {
				$('.inputAjustementBancaire' + pk + 'AjustementNomAffichage').val(o['ajustementNomAffichage']);
				$('.varAjustementBancaire' + pk + 'AjustementNomAffichage').text(o['ajustementNomAffichage']);
			}
			if(vars.includes('agentZones')) {
				$('.inputAjustementBancaire' + pk + 'AgentZones').val(o['agentZones']);
				$('.varAjustementBancaire' + pk + 'AgentZones').text(o['agentZones']);
			}
			if(vars.includes('agentRoles')) {
				$('.inputAjustementBancaire' + pk + 'AgentRoles').val(o['agentRoles']);
				$('.varAjustementBancaire' + pk + 'AgentRoles').text(o['agentRoles']);
			}
			if(vars.includes('agentPasserOutre')) {
				$('.inputAjustementBancaire' + pk + 'AgentPasserOutre').val(o['agentPasserOutre']);
				$('.varAjustementBancaire' + pk + 'AgentPasserOutre').text(o['agentPasserOutre']);
			}
			if(vars.includes('droitEligible')) {
				$('.inputAjustementBancaire' + pk + 'DroitEligible').val(o['droitEligible']);
				$('.varAjustementBancaire' + pk + 'DroitEligible').text(o['droitEligible']);
			}
			if(vars.includes('partenaireNom')) {
				$('.inputAjustementBancaire' + pk + 'PartenaireNom').val(o['partenaireNom']);
				$('.varAjustementBancaire' + pk + 'PartenaireNom').text(o['partenaireNom']);
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
		await patchAjustementBancaireVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
