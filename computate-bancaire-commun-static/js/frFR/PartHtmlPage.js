
// POST //

async function postPartHtml($formulaireValeurs, success, error) {
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

	var valeurArchive = $formulaireValeurs.find('.valeurArchive').prop('checked');
	if(valeurArchive != null && valeurArchive !== '')
		vals['archive'] = valeurArchive;

	var valeurSupprime = $formulaireValeurs.find('.valeurSupprime').prop('checked');
	if(valeurSupprime != null && valeurSupprime !== '')
		vals['supprime'] = valeurSupprime;

	var valeurDesignInscriptionCle = $formulaireValeurs.find('.valeurDesignInscriptionCle').val();
	if(valeurDesignInscriptionCle != null && valeurDesignInscriptionCle !== '')
		vals['designInscriptionCle'] = valeurDesignInscriptionCle;

	var valeurHtmlLien = $formulaireValeurs.find('.valeurHtmlLien').val();
	if(valeurHtmlLien != null && valeurHtmlLien !== '')
		vals['htmlLien'] = valeurHtmlLien;

	var valeurHtmlElement = $formulaireValeurs.find('.valeurHtmlElement').val();
	if(valeurHtmlElement != null && valeurHtmlElement !== '')
		vals['htmlElement'] = valeurHtmlElement;

	var valeurHtmlId = $formulaireValeurs.find('.valeurHtmlId').val();
	if(valeurHtmlId != null && valeurHtmlId !== '')
		vals['htmlId'] = valeurHtmlId;

	var valeurHtmlClasses = $formulaireValeurs.find('.valeurHtmlClasses').val();
	if(valeurHtmlClasses != null && valeurHtmlClasses !== '')
		vals['htmlClasses'] = valeurHtmlClasses;

	var valeurHtmlStyle = $formulaireValeurs.find('.valeurHtmlStyle').val();
	if(valeurHtmlStyle != null && valeurHtmlStyle !== '')
		vals['htmlStyle'] = valeurHtmlStyle;

	var valeurHtmlAvant = $formulaireValeurs.find('.valeurHtmlAvant').val();
	if(valeurHtmlAvant != null && valeurHtmlAvant !== '')
		vals['htmlAvant'] = valeurHtmlAvant;

	var valeurHtmlApres = $formulaireValeurs.find('.valeurHtmlApres').val();
	if(valeurHtmlApres != null && valeurHtmlApres !== '')
		vals['htmlApres'] = valeurHtmlApres;

	var valeurHtmlTexte = $formulaireValeurs.find('.valeurHtmlTexte').val();
	if(valeurHtmlTexte != null && valeurHtmlTexte !== '')
		vals['htmlTexte'] = valeurHtmlTexte;

	var valeurHtmlVar = $formulaireValeurs.find('.valeurHtmlVar').val();
	if(valeurHtmlVar != null && valeurHtmlVar !== '')
		vals['htmlVar'] = valeurHtmlVar;

	var valeurHtmlVarSpan = $formulaireValeurs.find('.valeurHtmlVarSpan').val();
	if(valeurHtmlVarSpan != null && valeurHtmlVarSpan !== '')
		vals['htmlVarSpan'] = valeurHtmlVarSpan;

	var valeurHtmlVarForm = $formulaireValeurs.find('.valeurHtmlVarForm').val();
	if(valeurHtmlVarForm != null && valeurHtmlVarForm !== '')
		vals['htmlVarForm'] = valeurHtmlVarForm;

	var valeurHtmlVarInput = $formulaireValeurs.find('.valeurHtmlVarInput').val();
	if(valeurHtmlVarInput != null && valeurHtmlVarInput !== '')
		vals['htmlVarInput'] = valeurHtmlVarInput;

	var valeurHtmlVarForEach = $formulaireValeurs.find('.valeurHtmlVarForEach').val();
	if(valeurHtmlVarForEach != null && valeurHtmlVarForEach !== '')
		vals['htmlVarForEach'] = valeurHtmlVarForEach;

	var valeurHtmlExclure = $formulaireValeurs.find('.valeurHtmlExclure').prop('checked');
	if(valeurHtmlExclure != null && valeurHtmlExclure !== '')
		vals['htmlExclure'] = valeurHtmlExclure;

	var valeurPdfExclure = $formulaireValeurs.find('.valeurPdfExclure').prop('checked');
	if(valeurPdfExclure != null && valeurPdfExclure !== '')
		vals['pdfExclure'] = valeurPdfExclure;

	var valeurTri1 = $formulaireValeurs.find('.valeurTri1').val();
	if(valeurTri1 != null && valeurTri1 !== '')
		vals['tri1'] = valeurTri1;

	var valeurTri2 = $formulaireValeurs.find('.valeurTri2').val();
	if(valeurTri2 != null && valeurTri2 !== '')
		vals['tri2'] = valeurTri2;

	var valeurTri3 = $formulaireValeurs.find('.valeurTri3').val();
	if(valeurTri3 != null && valeurTri3 !== '')
		vals['tri3'] = valeurTri3;

	var valeurTri4 = $formulaireValeurs.find('.valeurTri4').val();
	if(valeurTri4 != null && valeurTri4 !== '')
		vals['tri4'] = valeurTri4;

	var valeurTri5 = $formulaireValeurs.find('.valeurTri5').val();
	if(valeurTri5 != null && valeurTri5 !== '')
		vals['tri5'] = valeurTri5;

	var valeurTri6 = $formulaireValeurs.find('.valeurTri6').val();
	if(valeurTri6 != null && valeurTri6 !== '')
		vals['tri6'] = valeurTri6;

	var valeurTri7 = $formulaireValeurs.find('.valeurTri7').val();
	if(valeurTri7 != null && valeurTri7 !== '')
		vals['tri7'] = valeurTri7;

	var valeurTri8 = $formulaireValeurs.find('.valeurTri8').val();
	if(valeurTri8 != null && valeurTri8 !== '')
		vals['tri8'] = valeurTri8;

	var valeurTri9 = $formulaireValeurs.find('.valeurTri9').val();
	if(valeurTri9 != null && valeurTri9 !== '')
		vals['tri9'] = valeurTri9;

	var valeurTri10 = $formulaireValeurs.find('.valeurTri10').val();
	if(valeurTri10 != null && valeurTri10 !== '')
		vals['tri10'] = valeurTri10;

	$.ajax({
		url: '/api/part-html'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postPartHtmlVals(vals, success, error) {
	$.ajax({
		url: '/api/part-html'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchPartHtml($formulaireFiltres, $formulaireValeurs, success, error) {
	var filtres = patchPartHtmlFiltres($formulaireFiltres);

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

	var removeDesignInscriptionCle = $formulaireFiltres.find('.removeDesignInscriptionCle').val() === 'true';
	var setDesignInscriptionCle = removeDesignInscriptionCle ? null : $formulaireValeurs.find('.setDesignInscriptionCle').val();
	if(removeDesignInscriptionCle || setDesignInscriptionCle != null && setDesignInscriptionCle !== '')
		vals['setDesignInscriptionCle'] = setDesignInscriptionCle;
	var addDesignInscriptionCle = $formulaireValeurs.find('.addDesignInscriptionCle').val();
	if(addDesignInscriptionCle != null && addDesignInscriptionCle !== '')
		vals['addDesignInscriptionCle'] = addDesignInscriptionCle;
	var removeDesignInscriptionCle = $formulaireValeurs.find('.removeDesignInscriptionCle').val();
	if(removeDesignInscriptionCle != null && removeDesignInscriptionCle !== '')
		vals['removeDesignInscriptionCle'] = removeDesignInscriptionCle;

	var removeHtmlLien = $formulaireFiltres.find('.removeHtmlLien').val() === 'true';
	var setHtmlLien = removeHtmlLien ? null : $formulaireValeurs.find('.setHtmlLien').val();
	if(removeHtmlLien || setHtmlLien != null && setHtmlLien !== '')
		vals['setHtmlLien'] = setHtmlLien;
	var addHtmlLien = $formulaireValeurs.find('.addHtmlLien').val();
	if(addHtmlLien != null && addHtmlLien !== '')
		vals['addHtmlLien'] = addHtmlLien;
	var removeHtmlLien = $formulaireValeurs.find('.removeHtmlLien').val();
	if(removeHtmlLien != null && removeHtmlLien !== '')
		vals['removeHtmlLien'] = removeHtmlLien;

	var removeHtmlElement = $formulaireFiltres.find('.removeHtmlElement').val() === 'true';
	var setHtmlElement = removeHtmlElement ? null : $formulaireValeurs.find('.setHtmlElement').val();
	if(removeHtmlElement || setHtmlElement != null && setHtmlElement !== '')
		vals['setHtmlElement'] = setHtmlElement;
	var addHtmlElement = $formulaireValeurs.find('.addHtmlElement').val();
	if(addHtmlElement != null && addHtmlElement !== '')
		vals['addHtmlElement'] = addHtmlElement;
	var removeHtmlElement = $formulaireValeurs.find('.removeHtmlElement').val();
	if(removeHtmlElement != null && removeHtmlElement !== '')
		vals['removeHtmlElement'] = removeHtmlElement;

	var removeHtmlId = $formulaireFiltres.find('.removeHtmlId').val() === 'true';
	var setHtmlId = removeHtmlId ? null : $formulaireValeurs.find('.setHtmlId').val();
	if(removeHtmlId || setHtmlId != null && setHtmlId !== '')
		vals['setHtmlId'] = setHtmlId;
	var addHtmlId = $formulaireValeurs.find('.addHtmlId').val();
	if(addHtmlId != null && addHtmlId !== '')
		vals['addHtmlId'] = addHtmlId;
	var removeHtmlId = $formulaireValeurs.find('.removeHtmlId').val();
	if(removeHtmlId != null && removeHtmlId !== '')
		vals['removeHtmlId'] = removeHtmlId;

	var removeHtmlClasses = $formulaireFiltres.find('.removeHtmlClasses').val() === 'true';
	var setHtmlClasses = removeHtmlClasses ? null : $formulaireValeurs.find('.setHtmlClasses').val();
	if(removeHtmlClasses || setHtmlClasses != null && setHtmlClasses !== '')
		vals['setHtmlClasses'] = setHtmlClasses;
	var addHtmlClasses = $formulaireValeurs.find('.addHtmlClasses').val();
	if(addHtmlClasses != null && addHtmlClasses !== '')
		vals['addHtmlClasses'] = addHtmlClasses;
	var removeHtmlClasses = $formulaireValeurs.find('.removeHtmlClasses').val();
	if(removeHtmlClasses != null && removeHtmlClasses !== '')
		vals['removeHtmlClasses'] = removeHtmlClasses;

	var removeHtmlStyle = $formulaireFiltres.find('.removeHtmlStyle').val() === 'true';
	var setHtmlStyle = removeHtmlStyle ? null : $formulaireValeurs.find('.setHtmlStyle').val();
	if(removeHtmlStyle || setHtmlStyle != null && setHtmlStyle !== '')
		vals['setHtmlStyle'] = setHtmlStyle;
	var addHtmlStyle = $formulaireValeurs.find('.addHtmlStyle').val();
	if(addHtmlStyle != null && addHtmlStyle !== '')
		vals['addHtmlStyle'] = addHtmlStyle;
	var removeHtmlStyle = $formulaireValeurs.find('.removeHtmlStyle').val();
	if(removeHtmlStyle != null && removeHtmlStyle !== '')
		vals['removeHtmlStyle'] = removeHtmlStyle;

	var removeHtmlAvant = $formulaireFiltres.find('.removeHtmlAvant').val() === 'true';
	var setHtmlAvant = removeHtmlAvant ? null : $formulaireValeurs.find('.setHtmlAvant').val();
	if(removeHtmlAvant || setHtmlAvant != null && setHtmlAvant !== '')
		vals['setHtmlAvant'] = setHtmlAvant;
	var addHtmlAvant = $formulaireValeurs.find('.addHtmlAvant').val();
	if(addHtmlAvant != null && addHtmlAvant !== '')
		vals['addHtmlAvant'] = addHtmlAvant;
	var removeHtmlAvant = $formulaireValeurs.find('.removeHtmlAvant').val();
	if(removeHtmlAvant != null && removeHtmlAvant !== '')
		vals['removeHtmlAvant'] = removeHtmlAvant;

	var removeHtmlApres = $formulaireFiltres.find('.removeHtmlApres').val() === 'true';
	var setHtmlApres = removeHtmlApres ? null : $formulaireValeurs.find('.setHtmlApres').val();
	if(removeHtmlApres || setHtmlApres != null && setHtmlApres !== '')
		vals['setHtmlApres'] = setHtmlApres;
	var addHtmlApres = $formulaireValeurs.find('.addHtmlApres').val();
	if(addHtmlApres != null && addHtmlApres !== '')
		vals['addHtmlApres'] = addHtmlApres;
	var removeHtmlApres = $formulaireValeurs.find('.removeHtmlApres').val();
	if(removeHtmlApres != null && removeHtmlApres !== '')
		vals['removeHtmlApres'] = removeHtmlApres;

	var removeHtmlTexte = $formulaireFiltres.find('.removeHtmlTexte').val() === 'true';
	var setHtmlTexte = removeHtmlTexte ? null : $formulaireValeurs.find('.setHtmlTexte').val();
	if(removeHtmlTexte || setHtmlTexte != null && setHtmlTexte !== '')
		vals['setHtmlTexte'] = setHtmlTexte;
	var addHtmlTexte = $formulaireValeurs.find('.addHtmlTexte').val();
	if(addHtmlTexte != null && addHtmlTexte !== '')
		vals['addHtmlTexte'] = addHtmlTexte;
	var removeHtmlTexte = $formulaireValeurs.find('.removeHtmlTexte').val();
	if(removeHtmlTexte != null && removeHtmlTexte !== '')
		vals['removeHtmlTexte'] = removeHtmlTexte;

	var removeHtmlVar = $formulaireFiltres.find('.removeHtmlVar').val() === 'true';
	var setHtmlVar = removeHtmlVar ? null : $formulaireValeurs.find('.setHtmlVar').val();
	if(removeHtmlVar || setHtmlVar != null && setHtmlVar !== '')
		vals['setHtmlVar'] = setHtmlVar;
	var addHtmlVar = $formulaireValeurs.find('.addHtmlVar').val();
	if(addHtmlVar != null && addHtmlVar !== '')
		vals['addHtmlVar'] = addHtmlVar;
	var removeHtmlVar = $formulaireValeurs.find('.removeHtmlVar').val();
	if(removeHtmlVar != null && removeHtmlVar !== '')
		vals['removeHtmlVar'] = removeHtmlVar;

	var removeHtmlVarSpan = $formulaireFiltres.find('.removeHtmlVarSpan').val() === 'true';
	var setHtmlVarSpan = removeHtmlVarSpan ? null : $formulaireValeurs.find('.setHtmlVarSpan').val();
	if(removeHtmlVarSpan || setHtmlVarSpan != null && setHtmlVarSpan !== '')
		vals['setHtmlVarSpan'] = setHtmlVarSpan;
	var addHtmlVarSpan = $formulaireValeurs.find('.addHtmlVarSpan').val();
	if(addHtmlVarSpan != null && addHtmlVarSpan !== '')
		vals['addHtmlVarSpan'] = addHtmlVarSpan;
	var removeHtmlVarSpan = $formulaireValeurs.find('.removeHtmlVarSpan').val();
	if(removeHtmlVarSpan != null && removeHtmlVarSpan !== '')
		vals['removeHtmlVarSpan'] = removeHtmlVarSpan;

	var removeHtmlVarForm = $formulaireFiltres.find('.removeHtmlVarForm').val() === 'true';
	var setHtmlVarForm = removeHtmlVarForm ? null : $formulaireValeurs.find('.setHtmlVarForm').val();
	if(removeHtmlVarForm || setHtmlVarForm != null && setHtmlVarForm !== '')
		vals['setHtmlVarForm'] = setHtmlVarForm;
	var addHtmlVarForm = $formulaireValeurs.find('.addHtmlVarForm').val();
	if(addHtmlVarForm != null && addHtmlVarForm !== '')
		vals['addHtmlVarForm'] = addHtmlVarForm;
	var removeHtmlVarForm = $formulaireValeurs.find('.removeHtmlVarForm').val();
	if(removeHtmlVarForm != null && removeHtmlVarForm !== '')
		vals['removeHtmlVarForm'] = removeHtmlVarForm;

	var removeHtmlVarInput = $formulaireFiltres.find('.removeHtmlVarInput').val() === 'true';
	var setHtmlVarInput = removeHtmlVarInput ? null : $formulaireValeurs.find('.setHtmlVarInput').val();
	if(removeHtmlVarInput || setHtmlVarInput != null && setHtmlVarInput !== '')
		vals['setHtmlVarInput'] = setHtmlVarInput;
	var addHtmlVarInput = $formulaireValeurs.find('.addHtmlVarInput').val();
	if(addHtmlVarInput != null && addHtmlVarInput !== '')
		vals['addHtmlVarInput'] = addHtmlVarInput;
	var removeHtmlVarInput = $formulaireValeurs.find('.removeHtmlVarInput').val();
	if(removeHtmlVarInput != null && removeHtmlVarInput !== '')
		vals['removeHtmlVarInput'] = removeHtmlVarInput;

	var removeHtmlVarForEach = $formulaireFiltres.find('.removeHtmlVarForEach').val() === 'true';
	var setHtmlVarForEach = removeHtmlVarForEach ? null : $formulaireValeurs.find('.setHtmlVarForEach').val();
	if(removeHtmlVarForEach || setHtmlVarForEach != null && setHtmlVarForEach !== '')
		vals['setHtmlVarForEach'] = setHtmlVarForEach;
	var addHtmlVarForEach = $formulaireValeurs.find('.addHtmlVarForEach').val();
	if(addHtmlVarForEach != null && addHtmlVarForEach !== '')
		vals['addHtmlVarForEach'] = addHtmlVarForEach;
	var removeHtmlVarForEach = $formulaireValeurs.find('.removeHtmlVarForEach').val();
	if(removeHtmlVarForEach != null && removeHtmlVarForEach !== '')
		vals['removeHtmlVarForEach'] = removeHtmlVarForEach;

	var removeHtmlExclure = $formulaireFiltres.find('.removeHtmlExclure').val() === 'true';
	var setHtmlExclure = removeHtmlExclure ? null : $formulaireValeurs.find('.setHtmlExclure').prop('checked');
	if(removeHtmlExclure || setHtmlExclure != null && setHtmlExclure !== '')
		vals['setHtmlExclure'] = setHtmlExclure;
	var addHtmlExclure = $formulaireValeurs.find('.addHtmlExclure').prop('checked');
	if(addHtmlExclure != null && addHtmlExclure !== '')
		vals['addHtmlExclure'] = addHtmlExclure;
	var removeHtmlExclure = $formulaireValeurs.find('.removeHtmlExclure').prop('checked');
	if(removeHtmlExclure != null && removeHtmlExclure !== '')
		vals['removeHtmlExclure'] = removeHtmlExclure;

	var removePdfExclure = $formulaireFiltres.find('.removePdfExclure').val() === 'true';
	var setPdfExclure = removePdfExclure ? null : $formulaireValeurs.find('.setPdfExclure').prop('checked');
	if(removePdfExclure || setPdfExclure != null && setPdfExclure !== '')
		vals['setPdfExclure'] = setPdfExclure;
	var addPdfExclure = $formulaireValeurs.find('.addPdfExclure').prop('checked');
	if(addPdfExclure != null && addPdfExclure !== '')
		vals['addPdfExclure'] = addPdfExclure;
	var removePdfExclure = $formulaireValeurs.find('.removePdfExclure').prop('checked');
	if(removePdfExclure != null && removePdfExclure !== '')
		vals['removePdfExclure'] = removePdfExclure;

	var removeTri1 = $formulaireFiltres.find('.removeTri1').val() === 'true';
	var setTri1 = removeTri1 ? null : $formulaireValeurs.find('.setTri1').val();
	if(removeTri1 || setTri1 != null && setTri1 !== '')
		vals['setTri1'] = setTri1;
	var addTri1 = $formulaireValeurs.find('.addTri1').val();
	if(addTri1 != null && addTri1 !== '')
		vals['addTri1'] = addTri1;
	var removeTri1 = $formulaireValeurs.find('.removeTri1').val();
	if(removeTri1 != null && removeTri1 !== '')
		vals['removeTri1'] = removeTri1;

	var removeTri2 = $formulaireFiltres.find('.removeTri2').val() === 'true';
	var setTri2 = removeTri2 ? null : $formulaireValeurs.find('.setTri2').val();
	if(removeTri2 || setTri2 != null && setTri2 !== '')
		vals['setTri2'] = setTri2;
	var addTri2 = $formulaireValeurs.find('.addTri2').val();
	if(addTri2 != null && addTri2 !== '')
		vals['addTri2'] = addTri2;
	var removeTri2 = $formulaireValeurs.find('.removeTri2').val();
	if(removeTri2 != null && removeTri2 !== '')
		vals['removeTri2'] = removeTri2;

	var removeTri3 = $formulaireFiltres.find('.removeTri3').val() === 'true';
	var setTri3 = removeTri3 ? null : $formulaireValeurs.find('.setTri3').val();
	if(removeTri3 || setTri3 != null && setTri3 !== '')
		vals['setTri3'] = setTri3;
	var addTri3 = $formulaireValeurs.find('.addTri3').val();
	if(addTri3 != null && addTri3 !== '')
		vals['addTri3'] = addTri3;
	var removeTri3 = $formulaireValeurs.find('.removeTri3').val();
	if(removeTri3 != null && removeTri3 !== '')
		vals['removeTri3'] = removeTri3;

	var removeTri4 = $formulaireFiltres.find('.removeTri4').val() === 'true';
	var setTri4 = removeTri4 ? null : $formulaireValeurs.find('.setTri4').val();
	if(removeTri4 || setTri4 != null && setTri4 !== '')
		vals['setTri4'] = setTri4;
	var addTri4 = $formulaireValeurs.find('.addTri4').val();
	if(addTri4 != null && addTri4 !== '')
		vals['addTri4'] = addTri4;
	var removeTri4 = $formulaireValeurs.find('.removeTri4').val();
	if(removeTri4 != null && removeTri4 !== '')
		vals['removeTri4'] = removeTri4;

	var removeTri5 = $formulaireFiltres.find('.removeTri5').val() === 'true';
	var setTri5 = removeTri5 ? null : $formulaireValeurs.find('.setTri5').val();
	if(removeTri5 || setTri5 != null && setTri5 !== '')
		vals['setTri5'] = setTri5;
	var addTri5 = $formulaireValeurs.find('.addTri5').val();
	if(addTri5 != null && addTri5 !== '')
		vals['addTri5'] = addTri5;
	var removeTri5 = $formulaireValeurs.find('.removeTri5').val();
	if(removeTri5 != null && removeTri5 !== '')
		vals['removeTri5'] = removeTri5;

	var removeTri6 = $formulaireFiltres.find('.removeTri6').val() === 'true';
	var setTri6 = removeTri6 ? null : $formulaireValeurs.find('.setTri6').val();
	if(removeTri6 || setTri6 != null && setTri6 !== '')
		vals['setTri6'] = setTri6;
	var addTri6 = $formulaireValeurs.find('.addTri6').val();
	if(addTri6 != null && addTri6 !== '')
		vals['addTri6'] = addTri6;
	var removeTri6 = $formulaireValeurs.find('.removeTri6').val();
	if(removeTri6 != null && removeTri6 !== '')
		vals['removeTri6'] = removeTri6;

	var removeTri7 = $formulaireFiltres.find('.removeTri7').val() === 'true';
	var setTri7 = removeTri7 ? null : $formulaireValeurs.find('.setTri7').val();
	if(removeTri7 || setTri7 != null && setTri7 !== '')
		vals['setTri7'] = setTri7;
	var addTri7 = $formulaireValeurs.find('.addTri7').val();
	if(addTri7 != null && addTri7 !== '')
		vals['addTri7'] = addTri7;
	var removeTri7 = $formulaireValeurs.find('.removeTri7').val();
	if(removeTri7 != null && removeTri7 !== '')
		vals['removeTri7'] = removeTri7;

	var removeTri8 = $formulaireFiltres.find('.removeTri8').val() === 'true';
	var setTri8 = removeTri8 ? null : $formulaireValeurs.find('.setTri8').val();
	if(removeTri8 || setTri8 != null && setTri8 !== '')
		vals['setTri8'] = setTri8;
	var addTri8 = $formulaireValeurs.find('.addTri8').val();
	if(addTri8 != null && addTri8 !== '')
		vals['addTri8'] = addTri8;
	var removeTri8 = $formulaireValeurs.find('.removeTri8').val();
	if(removeTri8 != null && removeTri8 !== '')
		vals['removeTri8'] = removeTri8;

	var removeTri9 = $formulaireFiltres.find('.removeTri9').val() === 'true';
	var setTri9 = removeTri9 ? null : $formulaireValeurs.find('.setTri9').val();
	if(removeTri9 || setTri9 != null && setTri9 !== '')
		vals['setTri9'] = setTri9;
	var addTri9 = $formulaireValeurs.find('.addTri9').val();
	if(addTri9 != null && addTri9 !== '')
		vals['addTri9'] = addTri9;
	var removeTri9 = $formulaireValeurs.find('.removeTri9').val();
	if(removeTri9 != null && removeTri9 !== '')
		vals['removeTri9'] = removeTri9;

	var removeTri10 = $formulaireFiltres.find('.removeTri10').val() === 'true';
	var setTri10 = removeTri10 ? null : $formulaireValeurs.find('.setTri10').val();
	if(removeTri10 || setTri10 != null && setTri10 !== '')
		vals['setTri10'] = setTri10;
	var addTri10 = $formulaireValeurs.find('.addTri10').val();
	if(addTri10 != null && addTri10 !== '')
		vals['addTri10'] = addTri10;
	var removeTri10 = $formulaireValeurs.find('.removeTri10').val();
	if(removeTri10 != null && removeTri10 !== '')
		vals['removeTri10'] = removeTri10;

	patchPartHtmlVals(filtres, vals, success, error);
}

function patchPartHtmlFiltres($formulaireFiltres) {
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

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreDesignInscriptionCle = $formulaireFiltres.find('.valeurDesignInscriptionCle').val();
	if(filtreDesignInscriptionCle != null && filtreDesignInscriptionCle !== '')
		filtres.push({ name: 'fq', value: 'designInscriptionCle:' + filtreDesignInscriptionCle });

	var filtreHtmlLien = $formulaireFiltres.find('.valeurHtmlLien').val();
	if(filtreHtmlLien != null && filtreHtmlLien !== '')
		filtres.push({ name: 'fq', value: 'htmlLien:' + filtreHtmlLien });

	var filtreHtmlElement = $formulaireFiltres.find('.valeurHtmlElement').val();
	if(filtreHtmlElement != null && filtreHtmlElement !== '')
		filtres.push({ name: 'fq', value: 'htmlElement:' + filtreHtmlElement });

	var filtreHtmlId = $formulaireFiltres.find('.valeurHtmlId').val();
	if(filtreHtmlId != null && filtreHtmlId !== '')
		filtres.push({ name: 'fq', value: 'htmlId:' + filtreHtmlId });

	var filtreHtmlClasses = $formulaireFiltres.find('.valeurHtmlClasses').val();
	if(filtreHtmlClasses != null && filtreHtmlClasses !== '')
		filtres.push({ name: 'fq', value: 'htmlClasses:' + filtreHtmlClasses });

	var filtreHtmlStyle = $formulaireFiltres.find('.valeurHtmlStyle').val();
	if(filtreHtmlStyle != null && filtreHtmlStyle !== '')
		filtres.push({ name: 'fq', value: 'htmlStyle:' + filtreHtmlStyle });

	var filtreHtmlAvant = $formulaireFiltres.find('.valeurHtmlAvant').val();
	if(filtreHtmlAvant != null && filtreHtmlAvant !== '')
		filtres.push({ name: 'fq', value: 'htmlAvant:' + filtreHtmlAvant });

	var filtreHtmlApres = $formulaireFiltres.find('.valeurHtmlApres').val();
	if(filtreHtmlApres != null && filtreHtmlApres !== '')
		filtres.push({ name: 'fq', value: 'htmlApres:' + filtreHtmlApres });

	var filtreHtmlTexte = $formulaireFiltres.find('.valeurHtmlTexte').val();
	if(filtreHtmlTexte != null && filtreHtmlTexte !== '')
		filtres.push({ name: 'fq', value: 'htmlTexte:' + filtreHtmlTexte });

	var filtreHtmlVar = $formulaireFiltres.find('.valeurHtmlVar').val();
	if(filtreHtmlVar != null && filtreHtmlVar !== '')
		filtres.push({ name: 'fq', value: 'htmlVar:' + filtreHtmlVar });

	var filtreHtmlVarSpan = $formulaireFiltres.find('.valeurHtmlVarSpan').val();
	if(filtreHtmlVarSpan != null && filtreHtmlVarSpan !== '')
		filtres.push({ name: 'fq', value: 'htmlVarSpan:' + filtreHtmlVarSpan });

	var filtreHtmlVarForm = $formulaireFiltres.find('.valeurHtmlVarForm').val();
	if(filtreHtmlVarForm != null && filtreHtmlVarForm !== '')
		filtres.push({ name: 'fq', value: 'htmlVarForm:' + filtreHtmlVarForm });

	var filtreHtmlVarInput = $formulaireFiltres.find('.valeurHtmlVarInput').val();
	if(filtreHtmlVarInput != null && filtreHtmlVarInput !== '')
		filtres.push({ name: 'fq', value: 'htmlVarInput:' + filtreHtmlVarInput });

	var filtreHtmlVarForEach = $formulaireFiltres.find('.valeurHtmlVarForEach').val();
	if(filtreHtmlVarForEach != null && filtreHtmlVarForEach !== '')
		filtres.push({ name: 'fq', value: 'htmlVarForEach:' + filtreHtmlVarForEach });

	var filtreHtmlExclure = $formulaireFiltres.find('.valeurHtmlExclure').prop('checked');
	if(filtreHtmlExclure != null && filtreHtmlExclure === true)
		filtres.push({ name: 'fq', value: 'htmlExclure:' + filtreHtmlExclure });

	var filtrePdfExclure = $formulaireFiltres.find('.valeurPdfExclure').prop('checked');
	if(filtrePdfExclure != null && filtrePdfExclure === true)
		filtres.push({ name: 'fq', value: 'pdfExclure:' + filtrePdfExclure });

	var filtreTri1 = $formulaireFiltres.find('.valeurTri1').val();
	if(filtreTri1 != null && filtreTri1 !== '')
		filtres.push({ name: 'fq', value: 'tri1:' + filtreTri1 });

	var filtreTri2 = $formulaireFiltres.find('.valeurTri2').val();
	if(filtreTri2 != null && filtreTri2 !== '')
		filtres.push({ name: 'fq', value: 'tri2:' + filtreTri2 });

	var filtreTri3 = $formulaireFiltres.find('.valeurTri3').val();
	if(filtreTri3 != null && filtreTri3 !== '')
		filtres.push({ name: 'fq', value: 'tri3:' + filtreTri3 });

	var filtreTri4 = $formulaireFiltres.find('.valeurTri4').val();
	if(filtreTri4 != null && filtreTri4 !== '')
		filtres.push({ name: 'fq', value: 'tri4:' + filtreTri4 });

	var filtreTri5 = $formulaireFiltres.find('.valeurTri5').val();
	if(filtreTri5 != null && filtreTri5 !== '')
		filtres.push({ name: 'fq', value: 'tri5:' + filtreTri5 });

	var filtreTri6 = $formulaireFiltres.find('.valeurTri6').val();
	if(filtreTri6 != null && filtreTri6 !== '')
		filtres.push({ name: 'fq', value: 'tri6:' + filtreTri6 });

	var filtreTri7 = $formulaireFiltres.find('.valeurTri7').val();
	if(filtreTri7 != null && filtreTri7 !== '')
		filtres.push({ name: 'fq', value: 'tri7:' + filtreTri7 });

	var filtreTri8 = $formulaireFiltres.find('.valeurTri8').val();
	if(filtreTri8 != null && filtreTri8 !== '')
		filtres.push({ name: 'fq', value: 'tri8:' + filtreTri8 });

	var filtreTri9 = $formulaireFiltres.find('.valeurTri9').val();
	if(filtreTri9 != null && filtreTri9 !== '')
		filtres.push({ name: 'fq', value: 'tri9:' + filtreTri9 });

	var filtreTri10 = $formulaireFiltres.find('.valeurTri10').val();
	if(filtreTri10 != null && filtreTri10 !== '')
		filtres.push({ name: 'fq', value: 'tri10:' + filtreTri10 });

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

	var filtrePartHtmlCle = $formulaireFiltres.find('.valeurPartHtmlCle').val();
	if(filtrePartHtmlCle != null && filtrePartHtmlCle !== '')
		filtres.push({ name: 'fq', value: 'partHtmlCle:' + filtrePartHtmlCle });
	return filtres;
}

function patchPartHtmlVal(filtres, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchPartHtmlVals(filtres, vals, success, error);
}

function patchPartHtmlVals(filtres, vals, success, error) {
	$.ajax({
		url: '/api/part-html?' + $.param(filtres)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getPartHtml(pk) {
	$.ajax({
		url: '/api/part-html/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deletePartHtml(pk) {
	$.ajax({
		url: '/api/part-html/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Recherche //

async function recherchePartHtml($formulaireFiltres, success, error) {
	var filtres = recherchePartHtmlFiltres($formulaireFiltres);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	recherchePartHtmlVals(filtres, success, error);
}

function recherchePartHtmlFiltres($formulaireFiltres) {
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

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreDesignInscriptionCle = $formulaireFiltres.find('.valeurDesignInscriptionCle').val();
	if(filtreDesignInscriptionCle != null && filtreDesignInscriptionCle !== '')
		filtres.push({ name: 'fq', value: 'designInscriptionCle:' + filtreDesignInscriptionCle });

	var filtreHtmlLien = $formulaireFiltres.find('.valeurHtmlLien').val();
	if(filtreHtmlLien != null && filtreHtmlLien !== '')
		filtres.push({ name: 'fq', value: 'htmlLien:' + filtreHtmlLien });

	var filtreHtmlElement = $formulaireFiltres.find('.valeurHtmlElement').val();
	if(filtreHtmlElement != null && filtreHtmlElement !== '')
		filtres.push({ name: 'fq', value: 'htmlElement:' + filtreHtmlElement });

	var filtreHtmlId = $formulaireFiltres.find('.valeurHtmlId').val();
	if(filtreHtmlId != null && filtreHtmlId !== '')
		filtres.push({ name: 'fq', value: 'htmlId:' + filtreHtmlId });

	var filtreHtmlClasses = $formulaireFiltres.find('.valeurHtmlClasses').val();
	if(filtreHtmlClasses != null && filtreHtmlClasses !== '')
		filtres.push({ name: 'fq', value: 'htmlClasses:' + filtreHtmlClasses });

	var filtreHtmlStyle = $formulaireFiltres.find('.valeurHtmlStyle').val();
	if(filtreHtmlStyle != null && filtreHtmlStyle !== '')
		filtres.push({ name: 'fq', value: 'htmlStyle:' + filtreHtmlStyle });

	var filtreHtmlAvant = $formulaireFiltres.find('.valeurHtmlAvant').val();
	if(filtreHtmlAvant != null && filtreHtmlAvant !== '')
		filtres.push({ name: 'fq', value: 'htmlAvant:' + filtreHtmlAvant });

	var filtreHtmlApres = $formulaireFiltres.find('.valeurHtmlApres').val();
	if(filtreHtmlApres != null && filtreHtmlApres !== '')
		filtres.push({ name: 'fq', value: 'htmlApres:' + filtreHtmlApres });

	var filtreHtmlTexte = $formulaireFiltres.find('.valeurHtmlTexte').val();
	if(filtreHtmlTexte != null && filtreHtmlTexte !== '')
		filtres.push({ name: 'fq', value: 'htmlTexte:' + filtreHtmlTexte });

	var filtreHtmlVar = $formulaireFiltres.find('.valeurHtmlVar').val();
	if(filtreHtmlVar != null && filtreHtmlVar !== '')
		filtres.push({ name: 'fq', value: 'htmlVar:' + filtreHtmlVar });

	var filtreHtmlVarSpan = $formulaireFiltres.find('.valeurHtmlVarSpan').val();
	if(filtreHtmlVarSpan != null && filtreHtmlVarSpan !== '')
		filtres.push({ name: 'fq', value: 'htmlVarSpan:' + filtreHtmlVarSpan });

	var filtreHtmlVarForm = $formulaireFiltres.find('.valeurHtmlVarForm').val();
	if(filtreHtmlVarForm != null && filtreHtmlVarForm !== '')
		filtres.push({ name: 'fq', value: 'htmlVarForm:' + filtreHtmlVarForm });

	var filtreHtmlVarInput = $formulaireFiltres.find('.valeurHtmlVarInput').val();
	if(filtreHtmlVarInput != null && filtreHtmlVarInput !== '')
		filtres.push({ name: 'fq', value: 'htmlVarInput:' + filtreHtmlVarInput });

	var filtreHtmlVarForEach = $formulaireFiltres.find('.valeurHtmlVarForEach').val();
	if(filtreHtmlVarForEach != null && filtreHtmlVarForEach !== '')
		filtres.push({ name: 'fq', value: 'htmlVarForEach:' + filtreHtmlVarForEach });

	var filtreHtmlExclure = $formulaireFiltres.find('.valeurHtmlExclure').prop('checked');
	if(filtreHtmlExclure != null && filtreHtmlExclure === true)
		filtres.push({ name: 'fq', value: 'htmlExclure:' + filtreHtmlExclure });

	var filtrePdfExclure = $formulaireFiltres.find('.valeurPdfExclure').prop('checked');
	if(filtrePdfExclure != null && filtrePdfExclure === true)
		filtres.push({ name: 'fq', value: 'pdfExclure:' + filtrePdfExclure });

	var filtreTri1 = $formulaireFiltres.find('.valeurTri1').val();
	if(filtreTri1 != null && filtreTri1 !== '')
		filtres.push({ name: 'fq', value: 'tri1:' + filtreTri1 });

	var filtreTri2 = $formulaireFiltres.find('.valeurTri2').val();
	if(filtreTri2 != null && filtreTri2 !== '')
		filtres.push({ name: 'fq', value: 'tri2:' + filtreTri2 });

	var filtreTri3 = $formulaireFiltres.find('.valeurTri3').val();
	if(filtreTri3 != null && filtreTri3 !== '')
		filtres.push({ name: 'fq', value: 'tri3:' + filtreTri3 });

	var filtreTri4 = $formulaireFiltres.find('.valeurTri4').val();
	if(filtreTri4 != null && filtreTri4 !== '')
		filtres.push({ name: 'fq', value: 'tri4:' + filtreTri4 });

	var filtreTri5 = $formulaireFiltres.find('.valeurTri5').val();
	if(filtreTri5 != null && filtreTri5 !== '')
		filtres.push({ name: 'fq', value: 'tri5:' + filtreTri5 });

	var filtreTri6 = $formulaireFiltres.find('.valeurTri6').val();
	if(filtreTri6 != null && filtreTri6 !== '')
		filtres.push({ name: 'fq', value: 'tri6:' + filtreTri6 });

	var filtreTri7 = $formulaireFiltres.find('.valeurTri7').val();
	if(filtreTri7 != null && filtreTri7 !== '')
		filtres.push({ name: 'fq', value: 'tri7:' + filtreTri7 });

	var filtreTri8 = $formulaireFiltres.find('.valeurTri8').val();
	if(filtreTri8 != null && filtreTri8 !== '')
		filtres.push({ name: 'fq', value: 'tri8:' + filtreTri8 });

	var filtreTri9 = $formulaireFiltres.find('.valeurTri9').val();
	if(filtreTri9 != null && filtreTri9 !== '')
		filtres.push({ name: 'fq', value: 'tri9:' + filtreTri9 });

	var filtreTri10 = $formulaireFiltres.find('.valeurTri10').val();
	if(filtreTri10 != null && filtreTri10 !== '')
		filtres.push({ name: 'fq', value: 'tri10:' + filtreTri10 });

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

	var filtrePartHtmlCle = $formulaireFiltres.find('.valeurPartHtmlCle').val();
	if(filtrePartHtmlCle != null && filtrePartHtmlCle !== '')
		filtres.push({ name: 'fq', value: 'partHtmlCle:' + filtrePartHtmlCle });
	return filtres;
}

function recherchePartHtmlVals(filtres, success, error) {

	filtres.push({ name: 'rows', value: 1000000 });

	filtres.push({ name: 'sort', value: 'tri1 asc' });
	filtres.push({ name: 'sort', value: 'tri2 asc' });
	filtres.push({ name: 'sort', value: 'tri3 asc' });
	filtres.push({ name: 'sort', value: 'tri4 asc' });
	filtres.push({ name: 'sort', value: 'tri5 asc' });
	filtres.push({ name: 'sort', value: 'tri6 asc' });
	filtres.push({ name: 'sort', value: 'tri7 asc' });
	filtres.push({ name: 'sort', value: 'tri8 asc' });
	filtres.push({ name: 'sort', value: 'tri9 asc' });
	filtres.push({ name: 'sort', value: 'tri10 asc' });
	$.ajax({
		url: '/api/part-html?' + $.param(filtres)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggerePartHtmlObjetSuggere($formulaireFiltres, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'far fa-sun w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['objetTitre']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrlPk']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	rechercherPartHtmlVals($formulaireFiltres, success, error);
}

async function websocketPartHtml(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketPartHtml', function (error, message) {
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
				var $i = $('<i>').attr('class', 'far fa-sun w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modifier part de HTMLs');
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
async function websocketPartHtmlInner(requetePatch) {
	var pk = requetePatch['pk'];
	var pks = requetePatch['pks'];
	var classes = requetePatch['classes'];
	var vars = requetePatch['vars'];
	var empty = requetePatch['empty'];

	if(pk != null) {
		rechercherPartHtmlVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('cree')) {
				$('.inputPartHtml' + pk + 'Cree').val(o['cree']);
				$('.varPartHtml' + pk + 'Cree').text(o['cree']);
			}
			if(vars.includes('modifie')) {
				$('.inputPartHtml' + pk + 'Modifie').val(o['modifie']);
				$('.varPartHtml' + pk + 'Modifie').text(o['modifie']);
			}
			if(vars.includes('archive')) {
				$('.inputPartHtml' + pk + 'Archive').val(o['archive']);
				$('.varPartHtml' + pk + 'Archive').text(o['archive']);
			}
			if(vars.includes('supprime')) {
				$('.inputPartHtml' + pk + 'Supprime').val(o['supprime']);
				$('.varPartHtml' + pk + 'Supprime').text(o['supprime']);
			}
			if(vars.includes('htmlLien')) {
				$('.inputPartHtml' + pk + 'HtmlLien').val(o['htmlLien']);
				$('.varPartHtml' + pk + 'HtmlLien').text(o['htmlLien']);
			}
			if(vars.includes('htmlElement')) {
				$('.inputPartHtml' + pk + 'HtmlElement').val(o['htmlElement']);
				$('.varPartHtml' + pk + 'HtmlElement').text(o['htmlElement']);
			}
			if(vars.includes('htmlId')) {
				$('.inputPartHtml' + pk + 'HtmlId').val(o['htmlId']);
				$('.varPartHtml' + pk + 'HtmlId').text(o['htmlId']);
			}
			if(vars.includes('htmlClasses')) {
				$('.inputPartHtml' + pk + 'HtmlClasses').val(o['htmlClasses']);
				$('.varPartHtml' + pk + 'HtmlClasses').text(o['htmlClasses']);
			}
			if(vars.includes('htmlStyle')) {
				$('.inputPartHtml' + pk + 'HtmlStyle').val(o['htmlStyle']);
				$('.varPartHtml' + pk + 'HtmlStyle').text(o['htmlStyle']);
			}
			if(vars.includes('htmlAvant')) {
				$('.inputPartHtml' + pk + 'HtmlAvant').val(o['htmlAvant']);
				$('.varPartHtml' + pk + 'HtmlAvant').text(o['htmlAvant']);
			}
			if(vars.includes('htmlApres')) {
				$('.inputPartHtml' + pk + 'HtmlApres').val(o['htmlApres']);
				$('.varPartHtml' + pk + 'HtmlApres').text(o['htmlApres']);
			}
			if(vars.includes('htmlTexte')) {
				$('.inputPartHtml' + pk + 'HtmlTexte').val(o['htmlTexte']);
				$('.varPartHtml' + pk + 'HtmlTexte').text(o['htmlTexte']);
			}
			if(vars.includes('htmlVar')) {
				$('.inputPartHtml' + pk + 'HtmlVar').val(o['htmlVar']);
				$('.varPartHtml' + pk + 'HtmlVar').text(o['htmlVar']);
			}
			if(vars.includes('htmlVarSpan')) {
				$('.inputPartHtml' + pk + 'HtmlVarSpan').val(o['htmlVarSpan']);
				$('.varPartHtml' + pk + 'HtmlVarSpan').text(o['htmlVarSpan']);
			}
			if(vars.includes('htmlVarForm')) {
				$('.inputPartHtml' + pk + 'HtmlVarForm').val(o['htmlVarForm']);
				$('.varPartHtml' + pk + 'HtmlVarForm').text(o['htmlVarForm']);
			}
			if(vars.includes('htmlVarInput')) {
				$('.inputPartHtml' + pk + 'HtmlVarInput').val(o['htmlVarInput']);
				$('.varPartHtml' + pk + 'HtmlVarInput').text(o['htmlVarInput']);
			}
			if(vars.includes('htmlVarForEach')) {
				$('.inputPartHtml' + pk + 'HtmlVarForEach').val(o['htmlVarForEach']);
				$('.varPartHtml' + pk + 'HtmlVarForEach').text(o['htmlVarForEach']);
			}
			if(vars.includes('htmlExclure')) {
				$('.inputPartHtml' + pk + 'HtmlExclure').val(o['htmlExclure']);
				$('.varPartHtml' + pk + 'HtmlExclure').text(o['htmlExclure']);
			}
			if(vars.includes('pdfExclure')) {
				$('.inputPartHtml' + pk + 'PdfExclure').val(o['pdfExclure']);
				$('.varPartHtml' + pk + 'PdfExclure').text(o['pdfExclure']);
			}
			if(vars.includes('tri1')) {
				$('.inputPartHtml' + pk + 'Tri1').val(o['tri1']);
				$('.varPartHtml' + pk + 'Tri1').text(o['tri1']);
			}
			if(vars.includes('tri2')) {
				$('.inputPartHtml' + pk + 'Tri2').val(o['tri2']);
				$('.varPartHtml' + pk + 'Tri2').text(o['tri2']);
			}
			if(vars.includes('tri3')) {
				$('.inputPartHtml' + pk + 'Tri3').val(o['tri3']);
				$('.varPartHtml' + pk + 'Tri3').text(o['tri3']);
			}
			if(vars.includes('tri4')) {
				$('.inputPartHtml' + pk + 'Tri4').val(o['tri4']);
				$('.varPartHtml' + pk + 'Tri4').text(o['tri4']);
			}
			if(vars.includes('tri5')) {
				$('.inputPartHtml' + pk + 'Tri5').val(o['tri5']);
				$('.varPartHtml' + pk + 'Tri5').text(o['tri5']);
			}
			if(vars.includes('tri6')) {
				$('.inputPartHtml' + pk + 'Tri6').val(o['tri6']);
				$('.varPartHtml' + pk + 'Tri6').text(o['tri6']);
			}
			if(vars.includes('tri7')) {
				$('.inputPartHtml' + pk + 'Tri7').val(o['tri7']);
				$('.varPartHtml' + pk + 'Tri7').text(o['tri7']);
			}
			if(vars.includes('tri8')) {
				$('.inputPartHtml' + pk + 'Tri8').val(o['tri8']);
				$('.varPartHtml' + pk + 'Tri8').text(o['tri8']);
			}
			if(vars.includes('tri9')) {
				$('.inputPartHtml' + pk + 'Tri9').val(o['tri9']);
				$('.varPartHtml' + pk + 'Tri9').text(o['tri9']);
			}
			if(vars.includes('tri10')) {
				$('.inputPartHtml' + pk + 'Tri10').val(o['tri10']);
				$('.varPartHtml' + pk + 'Tri10').text(o['tri10']);
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
		await patchPartHtmlVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
