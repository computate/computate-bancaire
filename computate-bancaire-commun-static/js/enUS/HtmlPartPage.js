
// POST //

async function postHtmlPart($formValues, success, error) {
	var vals = {};
	if(success == null) {
		success = function( data, textStatus, jQxhr ) {
			addGlow($formValues.next('button'));
			var url = data['pageUrlPk'];
			if(url)
				window.location.href = url;
		};
	}
	if(error == null) {
		error = function( jqXhr, textStatus, errorThrown ) {
			addError($formValues.next('button'));
		};
	}

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueObjectId = $formValues.find('.valueObjectId').val();
	if(valueObjectId != null && valueObjectId !== '')
		vals['objectId'] = valueObjectId;

	var valueArchived = $formValues.find('.valueArchived').prop('checked');
	if(valueArchived != null && valueArchived !== '')
		vals['archived'] = valueArchived;

	var valueDeleted = $formValues.find('.valueDeleted').prop('checked');
	if(valueDeleted != null && valueDeleted !== '')
		vals['deleted'] = valueDeleted;

	var valueEnrollmentDesignKey = $formValues.find('.valueEnrollmentDesignKey').val();
	if(valueEnrollmentDesignKey != null && valueEnrollmentDesignKey !== '')
		vals['enrollmentDesignKey'] = valueEnrollmentDesignKey;

	var valueHtmlLink = $formValues.find('.valueHtmlLink').val();
	if(valueHtmlLink != null && valueHtmlLink !== '')
		vals['htmlLink'] = valueHtmlLink;

	var valueHtmlElement = $formValues.find('.valueHtmlElement').val();
	if(valueHtmlElement != null && valueHtmlElement !== '')
		vals['htmlElement'] = valueHtmlElement;

	var valueHtmlId = $formValues.find('.valueHtmlId').val();
	if(valueHtmlId != null && valueHtmlId !== '')
		vals['htmlId'] = valueHtmlId;

	var valueHtmlClasses = $formValues.find('.valueHtmlClasses').val();
	if(valueHtmlClasses != null && valueHtmlClasses !== '')
		vals['htmlClasses'] = valueHtmlClasses;

	var valueHtmlStyle = $formValues.find('.valueHtmlStyle').val();
	if(valueHtmlStyle != null && valueHtmlStyle !== '')
		vals['htmlStyle'] = valueHtmlStyle;

	var valueHtmlBefore = $formValues.find('.valueHtmlBefore').val();
	if(valueHtmlBefore != null && valueHtmlBefore !== '')
		vals['htmlBefore'] = valueHtmlBefore;

	var valueHtmlAfter = $formValues.find('.valueHtmlAfter').val();
	if(valueHtmlAfter != null && valueHtmlAfter !== '')
		vals['htmlAfter'] = valueHtmlAfter;

	var valueHtmlText = $formValues.find('.valueHtmlText').val();
	if(valueHtmlText != null && valueHtmlText !== '')
		vals['htmlText'] = valueHtmlText;

	var valueHtmlVar = $formValues.find('.valueHtmlVar').val();
	if(valueHtmlVar != null && valueHtmlVar !== '')
		vals['htmlVar'] = valueHtmlVar;

	var valueHtmlVarSpan = $formValues.find('.valueHtmlVarSpan').val();
	if(valueHtmlVarSpan != null && valueHtmlVarSpan !== '')
		vals['htmlVarSpan'] = valueHtmlVarSpan;

	var valueHtmlVarForm = $formValues.find('.valueHtmlVarForm').val();
	if(valueHtmlVarForm != null && valueHtmlVarForm !== '')
		vals['htmlVarForm'] = valueHtmlVarForm;

	var valueHtmlVarInput = $formValues.find('.valueHtmlVarInput').val();
	if(valueHtmlVarInput != null && valueHtmlVarInput !== '')
		vals['htmlVarInput'] = valueHtmlVarInput;

	var valueHtmlVarForEach = $formValues.find('.valueHtmlVarForEach').val();
	if(valueHtmlVarForEach != null && valueHtmlVarForEach !== '')
		vals['htmlVarForEach'] = valueHtmlVarForEach;

	var valueHtmlExclude = $formValues.find('.valueHtmlExclude').prop('checked');
	if(valueHtmlExclude != null && valueHtmlExclude !== '')
		vals['htmlExclude'] = valueHtmlExclude;

	var valuePdfExclude = $formValues.find('.valuePdfExclude').prop('checked');
	if(valuePdfExclude != null && valuePdfExclude !== '')
		vals['pdfExclude'] = valuePdfExclude;

	var valueSort1 = $formValues.find('.valueSort1').val();
	if(valueSort1 != null && valueSort1 !== '')
		vals['sort1'] = valueSort1;

	var valueSort2 = $formValues.find('.valueSort2').val();
	if(valueSort2 != null && valueSort2 !== '')
		vals['sort2'] = valueSort2;

	var valueSort3 = $formValues.find('.valueSort3').val();
	if(valueSort3 != null && valueSort3 !== '')
		vals['sort3'] = valueSort3;

	var valueSort4 = $formValues.find('.valueSort4').val();
	if(valueSort4 != null && valueSort4 !== '')
		vals['sort4'] = valueSort4;

	var valueSort5 = $formValues.find('.valueSort5').val();
	if(valueSort5 != null && valueSort5 !== '')
		vals['sort5'] = valueSort5;

	var valueSort6 = $formValues.find('.valueSort6').val();
	if(valueSort6 != null && valueSort6 !== '')
		vals['sort6'] = valueSort6;

	var valueSort7 = $formValues.find('.valueSort7').val();
	if(valueSort7 != null && valueSort7 !== '')
		vals['sort7'] = valueSort7;

	var valueSort8 = $formValues.find('.valueSort8').val();
	if(valueSort8 != null && valueSort8 !== '')
		vals['sort8'] = valueSort8;

	var valueSort9 = $formValues.find('.valueSort9').val();
	if(valueSort9 != null && valueSort9 !== '')
		vals['sort9'] = valueSort9;

	var valueSort10 = $formValues.find('.valueSort10').val();
	if(valueSort10 != null && valueSort10 !== '')
		vals['sort10'] = valueSort10;

	$.ajax({
		url: '/api/html-part'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postHtmlPartVals(vals, success, error) {
	$.ajax({
		url: '/api/html-part'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchHtmlPart($formFilters, $formValues, success, error) {
	var filters = patchHtmlPartFilters($formFilters);

	var vals = {};

	var removePk = $formFilters.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formValues.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formValues.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formValues.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCreated = $formFilters.find('.removeCreated').val() === 'true';
	var setCreated = removeCreated ? null : $formValues.find('.setCreated').val();
	if(removeCreated || setCreated != null && setCreated !== '')
		vals['setCreated'] = setCreated;
	var addCreated = $formValues.find('.addCreated').val();
	if(addCreated != null && addCreated !== '')
		vals['addCreated'] = addCreated;
	var removeCreated = $formValues.find('.removeCreated').val();
	if(removeCreated != null && removeCreated !== '')
		vals['removeCreated'] = removeCreated;

	var removeModified = $formFilters.find('.removeModified').val() === 'true';
	var setModified = removeModified ? null : $formValues.find('.setModified').val();
	if(removeModified || setModified != null && setModified !== '')
		vals['setModified'] = setModified;
	var addModified = $formValues.find('.addModified').val();
	if(addModified != null && addModified !== '')
		vals['addModified'] = addModified;
	var removeModified = $formValues.find('.removeModified').val();
	if(removeModified != null && removeModified !== '')
		vals['removeModified'] = removeModified;

	var removeObjectId = $formFilters.find('.removeObjectId').val() === 'true';
	var setObjectId = removeObjectId ? null : $formValues.find('.setObjectId').val();
	if(removeObjectId || setObjectId != null && setObjectId !== '')
		vals['setObjectId'] = setObjectId;
	var addObjectId = $formValues.find('.addObjectId').val();
	if(addObjectId != null && addObjectId !== '')
		vals['addObjectId'] = addObjectId;
	var removeObjectId = $formValues.find('.removeObjectId').val();
	if(removeObjectId != null && removeObjectId !== '')
		vals['removeObjectId'] = removeObjectId;

	var removeArchived = $formFilters.find('.removeArchived').val() === 'true';
	var setArchived = removeArchived ? null : $formValues.find('.setArchived').prop('checked');
	if(removeArchived || setArchived != null && setArchived !== '')
		vals['setArchived'] = setArchived;
	var addArchived = $formValues.find('.addArchived').prop('checked');
	if(addArchived != null && addArchived !== '')
		vals['addArchived'] = addArchived;
	var removeArchived = $formValues.find('.removeArchived').prop('checked');
	if(removeArchived != null && removeArchived !== '')
		vals['removeArchived'] = removeArchived;

	var removeDeleted = $formFilters.find('.removeDeleted').val() === 'true';
	var setDeleted = removeDeleted ? null : $formValues.find('.setDeleted').prop('checked');
	if(removeDeleted || setDeleted != null && setDeleted !== '')
		vals['setDeleted'] = setDeleted;
	var addDeleted = $formValues.find('.addDeleted').prop('checked');
	if(addDeleted != null && addDeleted !== '')
		vals['addDeleted'] = addDeleted;
	var removeDeleted = $formValues.find('.removeDeleted').prop('checked');
	if(removeDeleted != null && removeDeleted !== '')
		vals['removeDeleted'] = removeDeleted;

	var removeEnrollmentDesignKey = $formFilters.find('.removeEnrollmentDesignKey').val() === 'true';
	var setEnrollmentDesignKey = removeEnrollmentDesignKey ? null : $formValues.find('.setEnrollmentDesignKey').val();
	if(removeEnrollmentDesignKey || setEnrollmentDesignKey != null && setEnrollmentDesignKey !== '')
		vals['setEnrollmentDesignKey'] = setEnrollmentDesignKey;
	var addEnrollmentDesignKey = $formValues.find('.addEnrollmentDesignKey').val();
	if(addEnrollmentDesignKey != null && addEnrollmentDesignKey !== '')
		vals['addEnrollmentDesignKey'] = addEnrollmentDesignKey;
	var removeEnrollmentDesignKey = $formValues.find('.removeEnrollmentDesignKey').val();
	if(removeEnrollmentDesignKey != null && removeEnrollmentDesignKey !== '')
		vals['removeEnrollmentDesignKey'] = removeEnrollmentDesignKey;

	var removeHtmlLink = $formFilters.find('.removeHtmlLink').val() === 'true';
	var setHtmlLink = removeHtmlLink ? null : $formValues.find('.setHtmlLink').val();
	if(removeHtmlLink || setHtmlLink != null && setHtmlLink !== '')
		vals['setHtmlLink'] = setHtmlLink;
	var addHtmlLink = $formValues.find('.addHtmlLink').val();
	if(addHtmlLink != null && addHtmlLink !== '')
		vals['addHtmlLink'] = addHtmlLink;
	var removeHtmlLink = $formValues.find('.removeHtmlLink').val();
	if(removeHtmlLink != null && removeHtmlLink !== '')
		vals['removeHtmlLink'] = removeHtmlLink;

	var removeHtmlElement = $formFilters.find('.removeHtmlElement').val() === 'true';
	var setHtmlElement = removeHtmlElement ? null : $formValues.find('.setHtmlElement').val();
	if(removeHtmlElement || setHtmlElement != null && setHtmlElement !== '')
		vals['setHtmlElement'] = setHtmlElement;
	var addHtmlElement = $formValues.find('.addHtmlElement').val();
	if(addHtmlElement != null && addHtmlElement !== '')
		vals['addHtmlElement'] = addHtmlElement;
	var removeHtmlElement = $formValues.find('.removeHtmlElement').val();
	if(removeHtmlElement != null && removeHtmlElement !== '')
		vals['removeHtmlElement'] = removeHtmlElement;

	var removeHtmlId = $formFilters.find('.removeHtmlId').val() === 'true';
	var setHtmlId = removeHtmlId ? null : $formValues.find('.setHtmlId').val();
	if(removeHtmlId || setHtmlId != null && setHtmlId !== '')
		vals['setHtmlId'] = setHtmlId;
	var addHtmlId = $formValues.find('.addHtmlId').val();
	if(addHtmlId != null && addHtmlId !== '')
		vals['addHtmlId'] = addHtmlId;
	var removeHtmlId = $formValues.find('.removeHtmlId').val();
	if(removeHtmlId != null && removeHtmlId !== '')
		vals['removeHtmlId'] = removeHtmlId;

	var removeHtmlClasses = $formFilters.find('.removeHtmlClasses').val() === 'true';
	var setHtmlClasses = removeHtmlClasses ? null : $formValues.find('.setHtmlClasses').val();
	if(removeHtmlClasses || setHtmlClasses != null && setHtmlClasses !== '')
		vals['setHtmlClasses'] = setHtmlClasses;
	var addHtmlClasses = $formValues.find('.addHtmlClasses').val();
	if(addHtmlClasses != null && addHtmlClasses !== '')
		vals['addHtmlClasses'] = addHtmlClasses;
	var removeHtmlClasses = $formValues.find('.removeHtmlClasses').val();
	if(removeHtmlClasses != null && removeHtmlClasses !== '')
		vals['removeHtmlClasses'] = removeHtmlClasses;

	var removeHtmlStyle = $formFilters.find('.removeHtmlStyle').val() === 'true';
	var setHtmlStyle = removeHtmlStyle ? null : $formValues.find('.setHtmlStyle').val();
	if(removeHtmlStyle || setHtmlStyle != null && setHtmlStyle !== '')
		vals['setHtmlStyle'] = setHtmlStyle;
	var addHtmlStyle = $formValues.find('.addHtmlStyle').val();
	if(addHtmlStyle != null && addHtmlStyle !== '')
		vals['addHtmlStyle'] = addHtmlStyle;
	var removeHtmlStyle = $formValues.find('.removeHtmlStyle').val();
	if(removeHtmlStyle != null && removeHtmlStyle !== '')
		vals['removeHtmlStyle'] = removeHtmlStyle;

	var removeHtmlBefore = $formFilters.find('.removeHtmlBefore').val() === 'true';
	var setHtmlBefore = removeHtmlBefore ? null : $formValues.find('.setHtmlBefore').val();
	if(removeHtmlBefore || setHtmlBefore != null && setHtmlBefore !== '')
		vals['setHtmlBefore'] = setHtmlBefore;
	var addHtmlBefore = $formValues.find('.addHtmlBefore').val();
	if(addHtmlBefore != null && addHtmlBefore !== '')
		vals['addHtmlBefore'] = addHtmlBefore;
	var removeHtmlBefore = $formValues.find('.removeHtmlBefore').val();
	if(removeHtmlBefore != null && removeHtmlBefore !== '')
		vals['removeHtmlBefore'] = removeHtmlBefore;

	var removeHtmlAfter = $formFilters.find('.removeHtmlAfter').val() === 'true';
	var setHtmlAfter = removeHtmlAfter ? null : $formValues.find('.setHtmlAfter').val();
	if(removeHtmlAfter || setHtmlAfter != null && setHtmlAfter !== '')
		vals['setHtmlAfter'] = setHtmlAfter;
	var addHtmlAfter = $formValues.find('.addHtmlAfter').val();
	if(addHtmlAfter != null && addHtmlAfter !== '')
		vals['addHtmlAfter'] = addHtmlAfter;
	var removeHtmlAfter = $formValues.find('.removeHtmlAfter').val();
	if(removeHtmlAfter != null && removeHtmlAfter !== '')
		vals['removeHtmlAfter'] = removeHtmlAfter;

	var removeHtmlText = $formFilters.find('.removeHtmlText').val() === 'true';
	var setHtmlText = removeHtmlText ? null : $formValues.find('.setHtmlText').val();
	if(removeHtmlText || setHtmlText != null && setHtmlText !== '')
		vals['setHtmlText'] = setHtmlText;
	var addHtmlText = $formValues.find('.addHtmlText').val();
	if(addHtmlText != null && addHtmlText !== '')
		vals['addHtmlText'] = addHtmlText;
	var removeHtmlText = $formValues.find('.removeHtmlText').val();
	if(removeHtmlText != null && removeHtmlText !== '')
		vals['removeHtmlText'] = removeHtmlText;

	var removeHtmlVar = $formFilters.find('.removeHtmlVar').val() === 'true';
	var setHtmlVar = removeHtmlVar ? null : $formValues.find('.setHtmlVar').val();
	if(removeHtmlVar || setHtmlVar != null && setHtmlVar !== '')
		vals['setHtmlVar'] = setHtmlVar;
	var addHtmlVar = $formValues.find('.addHtmlVar').val();
	if(addHtmlVar != null && addHtmlVar !== '')
		vals['addHtmlVar'] = addHtmlVar;
	var removeHtmlVar = $formValues.find('.removeHtmlVar').val();
	if(removeHtmlVar != null && removeHtmlVar !== '')
		vals['removeHtmlVar'] = removeHtmlVar;

	var removeHtmlVarSpan = $formFilters.find('.removeHtmlVarSpan').val() === 'true';
	var setHtmlVarSpan = removeHtmlVarSpan ? null : $formValues.find('.setHtmlVarSpan').val();
	if(removeHtmlVarSpan || setHtmlVarSpan != null && setHtmlVarSpan !== '')
		vals['setHtmlVarSpan'] = setHtmlVarSpan;
	var addHtmlVarSpan = $formValues.find('.addHtmlVarSpan').val();
	if(addHtmlVarSpan != null && addHtmlVarSpan !== '')
		vals['addHtmlVarSpan'] = addHtmlVarSpan;
	var removeHtmlVarSpan = $formValues.find('.removeHtmlVarSpan').val();
	if(removeHtmlVarSpan != null && removeHtmlVarSpan !== '')
		vals['removeHtmlVarSpan'] = removeHtmlVarSpan;

	var removeHtmlVarForm = $formFilters.find('.removeHtmlVarForm').val() === 'true';
	var setHtmlVarForm = removeHtmlVarForm ? null : $formValues.find('.setHtmlVarForm').val();
	if(removeHtmlVarForm || setHtmlVarForm != null && setHtmlVarForm !== '')
		vals['setHtmlVarForm'] = setHtmlVarForm;
	var addHtmlVarForm = $formValues.find('.addHtmlVarForm').val();
	if(addHtmlVarForm != null && addHtmlVarForm !== '')
		vals['addHtmlVarForm'] = addHtmlVarForm;
	var removeHtmlVarForm = $formValues.find('.removeHtmlVarForm').val();
	if(removeHtmlVarForm != null && removeHtmlVarForm !== '')
		vals['removeHtmlVarForm'] = removeHtmlVarForm;

	var removeHtmlVarInput = $formFilters.find('.removeHtmlVarInput').val() === 'true';
	var setHtmlVarInput = removeHtmlVarInput ? null : $formValues.find('.setHtmlVarInput').val();
	if(removeHtmlVarInput || setHtmlVarInput != null && setHtmlVarInput !== '')
		vals['setHtmlVarInput'] = setHtmlVarInput;
	var addHtmlVarInput = $formValues.find('.addHtmlVarInput').val();
	if(addHtmlVarInput != null && addHtmlVarInput !== '')
		vals['addHtmlVarInput'] = addHtmlVarInput;
	var removeHtmlVarInput = $formValues.find('.removeHtmlVarInput').val();
	if(removeHtmlVarInput != null && removeHtmlVarInput !== '')
		vals['removeHtmlVarInput'] = removeHtmlVarInput;

	var removeHtmlVarForEach = $formFilters.find('.removeHtmlVarForEach').val() === 'true';
	var setHtmlVarForEach = removeHtmlVarForEach ? null : $formValues.find('.setHtmlVarForEach').val();
	if(removeHtmlVarForEach || setHtmlVarForEach != null && setHtmlVarForEach !== '')
		vals['setHtmlVarForEach'] = setHtmlVarForEach;
	var addHtmlVarForEach = $formValues.find('.addHtmlVarForEach').val();
	if(addHtmlVarForEach != null && addHtmlVarForEach !== '')
		vals['addHtmlVarForEach'] = addHtmlVarForEach;
	var removeHtmlVarForEach = $formValues.find('.removeHtmlVarForEach').val();
	if(removeHtmlVarForEach != null && removeHtmlVarForEach !== '')
		vals['removeHtmlVarForEach'] = removeHtmlVarForEach;

	var removeHtmlExclude = $formFilters.find('.removeHtmlExclude').val() === 'true';
	var setHtmlExclude = removeHtmlExclude ? null : $formValues.find('.setHtmlExclude').prop('checked');
	if(removeHtmlExclude || setHtmlExclude != null && setHtmlExclude !== '')
		vals['setHtmlExclude'] = setHtmlExclude;
	var addHtmlExclude = $formValues.find('.addHtmlExclude').prop('checked');
	if(addHtmlExclude != null && addHtmlExclude !== '')
		vals['addHtmlExclude'] = addHtmlExclude;
	var removeHtmlExclude = $formValues.find('.removeHtmlExclude').prop('checked');
	if(removeHtmlExclude != null && removeHtmlExclude !== '')
		vals['removeHtmlExclude'] = removeHtmlExclude;

	var removePdfExclude = $formFilters.find('.removePdfExclude').val() === 'true';
	var setPdfExclude = removePdfExclude ? null : $formValues.find('.setPdfExclude').prop('checked');
	if(removePdfExclude || setPdfExclude != null && setPdfExclude !== '')
		vals['setPdfExclude'] = setPdfExclude;
	var addPdfExclude = $formValues.find('.addPdfExclude').prop('checked');
	if(addPdfExclude != null && addPdfExclude !== '')
		vals['addPdfExclude'] = addPdfExclude;
	var removePdfExclude = $formValues.find('.removePdfExclude').prop('checked');
	if(removePdfExclude != null && removePdfExclude !== '')
		vals['removePdfExclude'] = removePdfExclude;

	var removeSort1 = $formFilters.find('.removeSort1').val() === 'true';
	var setSort1 = removeSort1 ? null : $formValues.find('.setSort1').val();
	if(removeSort1 || setSort1 != null && setSort1 !== '')
		vals['setSort1'] = setSort1;
	var addSort1 = $formValues.find('.addSort1').val();
	if(addSort1 != null && addSort1 !== '')
		vals['addSort1'] = addSort1;
	var removeSort1 = $formValues.find('.removeSort1').val();
	if(removeSort1 != null && removeSort1 !== '')
		vals['removeSort1'] = removeSort1;

	var removeSort2 = $formFilters.find('.removeSort2').val() === 'true';
	var setSort2 = removeSort2 ? null : $formValues.find('.setSort2').val();
	if(removeSort2 || setSort2 != null && setSort2 !== '')
		vals['setSort2'] = setSort2;
	var addSort2 = $formValues.find('.addSort2').val();
	if(addSort2 != null && addSort2 !== '')
		vals['addSort2'] = addSort2;
	var removeSort2 = $formValues.find('.removeSort2').val();
	if(removeSort2 != null && removeSort2 !== '')
		vals['removeSort2'] = removeSort2;

	var removeSort3 = $formFilters.find('.removeSort3').val() === 'true';
	var setSort3 = removeSort3 ? null : $formValues.find('.setSort3').val();
	if(removeSort3 || setSort3 != null && setSort3 !== '')
		vals['setSort3'] = setSort3;
	var addSort3 = $formValues.find('.addSort3').val();
	if(addSort3 != null && addSort3 !== '')
		vals['addSort3'] = addSort3;
	var removeSort3 = $formValues.find('.removeSort3').val();
	if(removeSort3 != null && removeSort3 !== '')
		vals['removeSort3'] = removeSort3;

	var removeSort4 = $formFilters.find('.removeSort4').val() === 'true';
	var setSort4 = removeSort4 ? null : $formValues.find('.setSort4').val();
	if(removeSort4 || setSort4 != null && setSort4 !== '')
		vals['setSort4'] = setSort4;
	var addSort4 = $formValues.find('.addSort4').val();
	if(addSort4 != null && addSort4 !== '')
		vals['addSort4'] = addSort4;
	var removeSort4 = $formValues.find('.removeSort4').val();
	if(removeSort4 != null && removeSort4 !== '')
		vals['removeSort4'] = removeSort4;

	var removeSort5 = $formFilters.find('.removeSort5').val() === 'true';
	var setSort5 = removeSort5 ? null : $formValues.find('.setSort5').val();
	if(removeSort5 || setSort5 != null && setSort5 !== '')
		vals['setSort5'] = setSort5;
	var addSort5 = $formValues.find('.addSort5').val();
	if(addSort5 != null && addSort5 !== '')
		vals['addSort5'] = addSort5;
	var removeSort5 = $formValues.find('.removeSort5').val();
	if(removeSort5 != null && removeSort5 !== '')
		vals['removeSort5'] = removeSort5;

	var removeSort6 = $formFilters.find('.removeSort6').val() === 'true';
	var setSort6 = removeSort6 ? null : $formValues.find('.setSort6').val();
	if(removeSort6 || setSort6 != null && setSort6 !== '')
		vals['setSort6'] = setSort6;
	var addSort6 = $formValues.find('.addSort6').val();
	if(addSort6 != null && addSort6 !== '')
		vals['addSort6'] = addSort6;
	var removeSort6 = $formValues.find('.removeSort6').val();
	if(removeSort6 != null && removeSort6 !== '')
		vals['removeSort6'] = removeSort6;

	var removeSort7 = $formFilters.find('.removeSort7').val() === 'true';
	var setSort7 = removeSort7 ? null : $formValues.find('.setSort7').val();
	if(removeSort7 || setSort7 != null && setSort7 !== '')
		vals['setSort7'] = setSort7;
	var addSort7 = $formValues.find('.addSort7').val();
	if(addSort7 != null && addSort7 !== '')
		vals['addSort7'] = addSort7;
	var removeSort7 = $formValues.find('.removeSort7').val();
	if(removeSort7 != null && removeSort7 !== '')
		vals['removeSort7'] = removeSort7;

	var removeSort8 = $formFilters.find('.removeSort8').val() === 'true';
	var setSort8 = removeSort8 ? null : $formValues.find('.setSort8').val();
	if(removeSort8 || setSort8 != null && setSort8 !== '')
		vals['setSort8'] = setSort8;
	var addSort8 = $formValues.find('.addSort8').val();
	if(addSort8 != null && addSort8 !== '')
		vals['addSort8'] = addSort8;
	var removeSort8 = $formValues.find('.removeSort8').val();
	if(removeSort8 != null && removeSort8 !== '')
		vals['removeSort8'] = removeSort8;

	var removeSort9 = $formFilters.find('.removeSort9').val() === 'true';
	var setSort9 = removeSort9 ? null : $formValues.find('.setSort9').val();
	if(removeSort9 || setSort9 != null && setSort9 !== '')
		vals['setSort9'] = setSort9;
	var addSort9 = $formValues.find('.addSort9').val();
	if(addSort9 != null && addSort9 !== '')
		vals['addSort9'] = addSort9;
	var removeSort9 = $formValues.find('.removeSort9').val();
	if(removeSort9 != null && removeSort9 !== '')
		vals['removeSort9'] = removeSort9;

	var removeSort10 = $formFilters.find('.removeSort10').val() === 'true';
	var setSort10 = removeSort10 ? null : $formValues.find('.setSort10').val();
	if(removeSort10 || setSort10 != null && setSort10 !== '')
		vals['setSort10'] = setSort10;
	var addSort10 = $formValues.find('.addSort10').val();
	if(addSort10 != null && addSort10 !== '')
		vals['addSort10'] = addSort10;
	var removeSort10 = $formValues.find('.removeSort10').val();
	if(removeSort10 != null && removeSort10 !== '')
		vals['removeSort10'] = removeSort10;

	patchHtmlPartVals(filters, vals, success, error);
}

function patchHtmlPartFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterEnrollmentDesignKey = $formFilters.find('.valueEnrollmentDesignKey').val();
	if(filterEnrollmentDesignKey != null && filterEnrollmentDesignKey !== '')
		filters.push({ name: 'fq', value: 'enrollmentDesignKey:' + filterEnrollmentDesignKey });

	var filterHtmlLink = $formFilters.find('.valueHtmlLink').val();
	if(filterHtmlLink != null && filterHtmlLink !== '')
		filters.push({ name: 'fq', value: 'htmlLink:' + filterHtmlLink });

	var filterHtmlElement = $formFilters.find('.valueHtmlElement').val();
	if(filterHtmlElement != null && filterHtmlElement !== '')
		filters.push({ name: 'fq', value: 'htmlElement:' + filterHtmlElement });

	var filterHtmlId = $formFilters.find('.valueHtmlId').val();
	if(filterHtmlId != null && filterHtmlId !== '')
		filters.push({ name: 'fq', value: 'htmlId:' + filterHtmlId });

	var filterHtmlClasses = $formFilters.find('.valueHtmlClasses').val();
	if(filterHtmlClasses != null && filterHtmlClasses !== '')
		filters.push({ name: 'fq', value: 'htmlClasses:' + filterHtmlClasses });

	var filterHtmlStyle = $formFilters.find('.valueHtmlStyle').val();
	if(filterHtmlStyle != null && filterHtmlStyle !== '')
		filters.push({ name: 'fq', value: 'htmlStyle:' + filterHtmlStyle });

	var filterHtmlBefore = $formFilters.find('.valueHtmlBefore').val();
	if(filterHtmlBefore != null && filterHtmlBefore !== '')
		filters.push({ name: 'fq', value: 'htmlBefore:' + filterHtmlBefore });

	var filterHtmlAfter = $formFilters.find('.valueHtmlAfter').val();
	if(filterHtmlAfter != null && filterHtmlAfter !== '')
		filters.push({ name: 'fq', value: 'htmlAfter:' + filterHtmlAfter });

	var filterHtmlText = $formFilters.find('.valueHtmlText').val();
	if(filterHtmlText != null && filterHtmlText !== '')
		filters.push({ name: 'fq', value: 'htmlText:' + filterHtmlText });

	var filterHtmlVar = $formFilters.find('.valueHtmlVar').val();
	if(filterHtmlVar != null && filterHtmlVar !== '')
		filters.push({ name: 'fq', value: 'htmlVar:' + filterHtmlVar });

	var filterHtmlVarSpan = $formFilters.find('.valueHtmlVarSpan').val();
	if(filterHtmlVarSpan != null && filterHtmlVarSpan !== '')
		filters.push({ name: 'fq', value: 'htmlVarSpan:' + filterHtmlVarSpan });

	var filterHtmlVarForm = $formFilters.find('.valueHtmlVarForm').val();
	if(filterHtmlVarForm != null && filterHtmlVarForm !== '')
		filters.push({ name: 'fq', value: 'htmlVarForm:' + filterHtmlVarForm });

	var filterHtmlVarInput = $formFilters.find('.valueHtmlVarInput').val();
	if(filterHtmlVarInput != null && filterHtmlVarInput !== '')
		filters.push({ name: 'fq', value: 'htmlVarInput:' + filterHtmlVarInput });

	var filterHtmlVarForEach = $formFilters.find('.valueHtmlVarForEach').val();
	if(filterHtmlVarForEach != null && filterHtmlVarForEach !== '')
		filters.push({ name: 'fq', value: 'htmlVarForEach:' + filterHtmlVarForEach });

	var filterHtmlExclude = $formFilters.find('.valueHtmlExclude').prop('checked');
	if(filterHtmlExclude != null && filterHtmlExclude === true)
		filters.push({ name: 'fq', value: 'htmlExclude:' + filterHtmlExclude });

	var filterPdfExclude = $formFilters.find('.valuePdfExclude').prop('checked');
	if(filterPdfExclude != null && filterPdfExclude === true)
		filters.push({ name: 'fq', value: 'pdfExclude:' + filterPdfExclude });

	var filterSort1 = $formFilters.find('.valueSort1').val();
	if(filterSort1 != null && filterSort1 !== '')
		filters.push({ name: 'fq', value: 'sort1:' + filterSort1 });

	var filterSort2 = $formFilters.find('.valueSort2').val();
	if(filterSort2 != null && filterSort2 !== '')
		filters.push({ name: 'fq', value: 'sort2:' + filterSort2 });

	var filterSort3 = $formFilters.find('.valueSort3').val();
	if(filterSort3 != null && filterSort3 !== '')
		filters.push({ name: 'fq', value: 'sort3:' + filterSort3 });

	var filterSort4 = $formFilters.find('.valueSort4').val();
	if(filterSort4 != null && filterSort4 !== '')
		filters.push({ name: 'fq', value: 'sort4:' + filterSort4 });

	var filterSort5 = $formFilters.find('.valueSort5').val();
	if(filterSort5 != null && filterSort5 !== '')
		filters.push({ name: 'fq', value: 'sort5:' + filterSort5 });

	var filterSort6 = $formFilters.find('.valueSort6').val();
	if(filterSort6 != null && filterSort6 !== '')
		filters.push({ name: 'fq', value: 'sort6:' + filterSort6 });

	var filterSort7 = $formFilters.find('.valueSort7').val();
	if(filterSort7 != null && filterSort7 !== '')
		filters.push({ name: 'fq', value: 'sort7:' + filterSort7 });

	var filterSort8 = $formFilters.find('.valueSort8').val();
	if(filterSort8 != null && filterSort8 !== '')
		filters.push({ name: 'fq', value: 'sort8:' + filterSort8 });

	var filterSort9 = $formFilters.find('.valueSort9').val();
	if(filterSort9 != null && filterSort9 !== '')
		filters.push({ name: 'fq', value: 'sort9:' + filterSort9 });

	var filterSort10 = $formFilters.find('.valueSort10').val();
	if(filterSort10 != null && filterSort10 !== '')
		filters.push({ name: 'fq', value: 'sort10:' + filterSort10 });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterSessionId = $formFilters.find('.valueSessionId').val();
	if(filterSessionId != null && filterSessionId !== '')
		filters.push({ name: 'fq', value: 'sessionId:' + filterSessionId });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrlId = $formFilters.find('.valuePageUrlId').val();
	if(filterPageUrlId != null && filterPageUrlId !== '')
		filters.push({ name: 'fq', value: 'pageUrlId:' + filterPageUrlId });

	var filterPageUrlPk = $formFilters.find('.valuePageUrlPk').val();
	if(filterPageUrlPk != null && filterPageUrlPk !== '')
		filters.push({ name: 'fq', value: 'pageUrlPk:' + filterPageUrlPk });

	var filterHtmlPartKey = $formFilters.find('.valueHtmlPartKey').val();
	if(filterHtmlPartKey != null && filterHtmlPartKey !== '')
		filters.push({ name: 'fq', value: 'htmlPartKey:' + filterHtmlPartKey });
	return filters;
}

function patchHtmlPartVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchHtmlPartVals(filters, vals, success, error);
}

function patchHtmlPartVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/html-part?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getHtmlPart(pk) {
	$.ajax({
		url: '/api/html-part/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteHtmlPart(pk) {
	$.ajax({
		url: '/api/html-part/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Search //

async function searchHtmlPart($formFilters, success, error) {
	var filters = searchHtmlPartFilters($formFilters);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	searchHtmlPartVals(filters, success, error);
}

function searchHtmlPartFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterEnrollmentDesignKey = $formFilters.find('.valueEnrollmentDesignKey').val();
	if(filterEnrollmentDesignKey != null && filterEnrollmentDesignKey !== '')
		filters.push({ name: 'fq', value: 'enrollmentDesignKey:' + filterEnrollmentDesignKey });

	var filterHtmlLink = $formFilters.find('.valueHtmlLink').val();
	if(filterHtmlLink != null && filterHtmlLink !== '')
		filters.push({ name: 'fq', value: 'htmlLink:' + filterHtmlLink });

	var filterHtmlElement = $formFilters.find('.valueHtmlElement').val();
	if(filterHtmlElement != null && filterHtmlElement !== '')
		filters.push({ name: 'fq', value: 'htmlElement:' + filterHtmlElement });

	var filterHtmlId = $formFilters.find('.valueHtmlId').val();
	if(filterHtmlId != null && filterHtmlId !== '')
		filters.push({ name: 'fq', value: 'htmlId:' + filterHtmlId });

	var filterHtmlClasses = $formFilters.find('.valueHtmlClasses').val();
	if(filterHtmlClasses != null && filterHtmlClasses !== '')
		filters.push({ name: 'fq', value: 'htmlClasses:' + filterHtmlClasses });

	var filterHtmlStyle = $formFilters.find('.valueHtmlStyle').val();
	if(filterHtmlStyle != null && filterHtmlStyle !== '')
		filters.push({ name: 'fq', value: 'htmlStyle:' + filterHtmlStyle });

	var filterHtmlBefore = $formFilters.find('.valueHtmlBefore').val();
	if(filterHtmlBefore != null && filterHtmlBefore !== '')
		filters.push({ name: 'fq', value: 'htmlBefore:' + filterHtmlBefore });

	var filterHtmlAfter = $formFilters.find('.valueHtmlAfter').val();
	if(filterHtmlAfter != null && filterHtmlAfter !== '')
		filters.push({ name: 'fq', value: 'htmlAfter:' + filterHtmlAfter });

	var filterHtmlText = $formFilters.find('.valueHtmlText').val();
	if(filterHtmlText != null && filterHtmlText !== '')
		filters.push({ name: 'fq', value: 'htmlText:' + filterHtmlText });

	var filterHtmlVar = $formFilters.find('.valueHtmlVar').val();
	if(filterHtmlVar != null && filterHtmlVar !== '')
		filters.push({ name: 'fq', value: 'htmlVar:' + filterHtmlVar });

	var filterHtmlVarSpan = $formFilters.find('.valueHtmlVarSpan').val();
	if(filterHtmlVarSpan != null && filterHtmlVarSpan !== '')
		filters.push({ name: 'fq', value: 'htmlVarSpan:' + filterHtmlVarSpan });

	var filterHtmlVarForm = $formFilters.find('.valueHtmlVarForm').val();
	if(filterHtmlVarForm != null && filterHtmlVarForm !== '')
		filters.push({ name: 'fq', value: 'htmlVarForm:' + filterHtmlVarForm });

	var filterHtmlVarInput = $formFilters.find('.valueHtmlVarInput').val();
	if(filterHtmlVarInput != null && filterHtmlVarInput !== '')
		filters.push({ name: 'fq', value: 'htmlVarInput:' + filterHtmlVarInput });

	var filterHtmlVarForEach = $formFilters.find('.valueHtmlVarForEach').val();
	if(filterHtmlVarForEach != null && filterHtmlVarForEach !== '')
		filters.push({ name: 'fq', value: 'htmlVarForEach:' + filterHtmlVarForEach });

	var filterHtmlExclude = $formFilters.find('.valueHtmlExclude').prop('checked');
	if(filterHtmlExclude != null && filterHtmlExclude === true)
		filters.push({ name: 'fq', value: 'htmlExclude:' + filterHtmlExclude });

	var filterPdfExclude = $formFilters.find('.valuePdfExclude').prop('checked');
	if(filterPdfExclude != null && filterPdfExclude === true)
		filters.push({ name: 'fq', value: 'pdfExclude:' + filterPdfExclude });

	var filterSort1 = $formFilters.find('.valueSort1').val();
	if(filterSort1 != null && filterSort1 !== '')
		filters.push({ name: 'fq', value: 'sort1:' + filterSort1 });

	var filterSort2 = $formFilters.find('.valueSort2').val();
	if(filterSort2 != null && filterSort2 !== '')
		filters.push({ name: 'fq', value: 'sort2:' + filterSort2 });

	var filterSort3 = $formFilters.find('.valueSort3').val();
	if(filterSort3 != null && filterSort3 !== '')
		filters.push({ name: 'fq', value: 'sort3:' + filterSort3 });

	var filterSort4 = $formFilters.find('.valueSort4').val();
	if(filterSort4 != null && filterSort4 !== '')
		filters.push({ name: 'fq', value: 'sort4:' + filterSort4 });

	var filterSort5 = $formFilters.find('.valueSort5').val();
	if(filterSort5 != null && filterSort5 !== '')
		filters.push({ name: 'fq', value: 'sort5:' + filterSort5 });

	var filterSort6 = $formFilters.find('.valueSort6').val();
	if(filterSort6 != null && filterSort6 !== '')
		filters.push({ name: 'fq', value: 'sort6:' + filterSort6 });

	var filterSort7 = $formFilters.find('.valueSort7').val();
	if(filterSort7 != null && filterSort7 !== '')
		filters.push({ name: 'fq', value: 'sort7:' + filterSort7 });

	var filterSort8 = $formFilters.find('.valueSort8').val();
	if(filterSort8 != null && filterSort8 !== '')
		filters.push({ name: 'fq', value: 'sort8:' + filterSort8 });

	var filterSort9 = $formFilters.find('.valueSort9').val();
	if(filterSort9 != null && filterSort9 !== '')
		filters.push({ name: 'fq', value: 'sort9:' + filterSort9 });

	var filterSort10 = $formFilters.find('.valueSort10').val();
	if(filterSort10 != null && filterSort10 !== '')
		filters.push({ name: 'fq', value: 'sort10:' + filterSort10 });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterSessionId = $formFilters.find('.valueSessionId').val();
	if(filterSessionId != null && filterSessionId !== '')
		filters.push({ name: 'fq', value: 'sessionId:' + filterSessionId });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrlId = $formFilters.find('.valuePageUrlId').val();
	if(filterPageUrlId != null && filterPageUrlId !== '')
		filters.push({ name: 'fq', value: 'pageUrlId:' + filterPageUrlId });

	var filterPageUrlPk = $formFilters.find('.valuePageUrlPk').val();
	if(filterPageUrlPk != null && filterPageUrlPk !== '')
		filters.push({ name: 'fq', value: 'pageUrlPk:' + filterPageUrlPk });

	var filterHtmlPartKey = $formFilters.find('.valueHtmlPartKey').val();
	if(filterHtmlPartKey != null && filterHtmlPartKey !== '')
		filters.push({ name: 'fq', value: 'htmlPartKey:' + filterHtmlPartKey });
	return filters;
}

function searchHtmlPartVals(filters, success, error) {

	filters.push({ name: 'rows', value: 1000000 });

	filters.push({ name: 'sort', value: 'sort1 asc' });
	filters.push({ name: 'sort', value: 'sort2 asc' });
	filters.push({ name: 'sort', value: 'sort3 asc' });
	filters.push({ name: 'sort', value: 'sort4 asc' });
	filters.push({ name: 'sort', value: 'sort5 asc' });
	filters.push({ name: 'sort', value: 'sort6 asc' });
	filters.push({ name: 'sort', value: 'sort7 asc' });
	filters.push({ name: 'sort', value: 'sort8 asc' });
	filters.push({ name: 'sort', value: 'sort9 asc' });
	filters.push({ name: 'sort', value: 'sort10 asc' });
	$.ajax({
		url: '/api/html-part?' + $.param(filters)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggestHtmlPartObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'far fa-sun w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['objectTitle']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrlPk']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchHtmlPartVals($formFilters, success, error);
}

async function websocketHtmlPart(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketHtmlPart', function (error, message) {
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
				var $headerSpan = $('<span>').attr('class', '').text('modify HTML parts');
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
async function websocketHtmlPartInner(patchRequest) {
	var pk = patchRequest['pk'];
	var pks = patchRequest['pks'];
	var classes = patchRequest['classes'];
	var vars = patchRequest['vars'];
	var empty = patchRequest['empty'];

	if(pk != null) {
		searchHtmlPartVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('created')) {
				$('.inputHtmlPart' + pk + 'Created').val(o['created']);
				$('.varHtmlPart' + pk + 'Created').text(o['created']);
			}
			if(vars.includes('modified')) {
				$('.inputHtmlPart' + pk + 'Modified').val(o['modified']);
				$('.varHtmlPart' + pk + 'Modified').text(o['modified']);
			}
			if(vars.includes('archived')) {
				$('.inputHtmlPart' + pk + 'Archived').val(o['archived']);
				$('.varHtmlPart' + pk + 'Archived').text(o['archived']);
			}
			if(vars.includes('deleted')) {
				$('.inputHtmlPart' + pk + 'Deleted').val(o['deleted']);
				$('.varHtmlPart' + pk + 'Deleted').text(o['deleted']);
			}
			if(vars.includes('htmlLink')) {
				$('.inputHtmlPart' + pk + 'HtmlLink').val(o['htmlLink']);
				$('.varHtmlPart' + pk + 'HtmlLink').text(o['htmlLink']);
			}
			if(vars.includes('htmlElement')) {
				$('.inputHtmlPart' + pk + 'HtmlElement').val(o['htmlElement']);
				$('.varHtmlPart' + pk + 'HtmlElement').text(o['htmlElement']);
			}
			if(vars.includes('htmlId')) {
				$('.inputHtmlPart' + pk + 'HtmlId').val(o['htmlId']);
				$('.varHtmlPart' + pk + 'HtmlId').text(o['htmlId']);
			}
			if(vars.includes('htmlClasses')) {
				$('.inputHtmlPart' + pk + 'HtmlClasses').val(o['htmlClasses']);
				$('.varHtmlPart' + pk + 'HtmlClasses').text(o['htmlClasses']);
			}
			if(vars.includes('htmlStyle')) {
				$('.inputHtmlPart' + pk + 'HtmlStyle').val(o['htmlStyle']);
				$('.varHtmlPart' + pk + 'HtmlStyle').text(o['htmlStyle']);
			}
			if(vars.includes('htmlBefore')) {
				$('.inputHtmlPart' + pk + 'HtmlBefore').val(o['htmlBefore']);
				$('.varHtmlPart' + pk + 'HtmlBefore').text(o['htmlBefore']);
			}
			if(vars.includes('htmlAfter')) {
				$('.inputHtmlPart' + pk + 'HtmlAfter').val(o['htmlAfter']);
				$('.varHtmlPart' + pk + 'HtmlAfter').text(o['htmlAfter']);
			}
			if(vars.includes('htmlText')) {
				$('.inputHtmlPart' + pk + 'HtmlText').val(o['htmlText']);
				$('.varHtmlPart' + pk + 'HtmlText').text(o['htmlText']);
			}
			if(vars.includes('htmlVar')) {
				$('.inputHtmlPart' + pk + 'HtmlVar').val(o['htmlVar']);
				$('.varHtmlPart' + pk + 'HtmlVar').text(o['htmlVar']);
			}
			if(vars.includes('htmlVarSpan')) {
				$('.inputHtmlPart' + pk + 'HtmlVarSpan').val(o['htmlVarSpan']);
				$('.varHtmlPart' + pk + 'HtmlVarSpan').text(o['htmlVarSpan']);
			}
			if(vars.includes('htmlVarForm')) {
				$('.inputHtmlPart' + pk + 'HtmlVarForm').val(o['htmlVarForm']);
				$('.varHtmlPart' + pk + 'HtmlVarForm').text(o['htmlVarForm']);
			}
			if(vars.includes('htmlVarInput')) {
				$('.inputHtmlPart' + pk + 'HtmlVarInput').val(o['htmlVarInput']);
				$('.varHtmlPart' + pk + 'HtmlVarInput').text(o['htmlVarInput']);
			}
			if(vars.includes('htmlVarForEach')) {
				$('.inputHtmlPart' + pk + 'HtmlVarForEach').val(o['htmlVarForEach']);
				$('.varHtmlPart' + pk + 'HtmlVarForEach').text(o['htmlVarForEach']);
			}
			if(vars.includes('htmlExclude')) {
				$('.inputHtmlPart' + pk + 'HtmlExclude').val(o['htmlExclude']);
				$('.varHtmlPart' + pk + 'HtmlExclude').text(o['htmlExclude']);
			}
			if(vars.includes('pdfExclude')) {
				$('.inputHtmlPart' + pk + 'PdfExclude').val(o['pdfExclude']);
				$('.varHtmlPart' + pk + 'PdfExclude').text(o['pdfExclude']);
			}
			if(vars.includes('sort1')) {
				$('.inputHtmlPart' + pk + 'Sort1').val(o['sort1']);
				$('.varHtmlPart' + pk + 'Sort1').text(o['sort1']);
			}
			if(vars.includes('sort2')) {
				$('.inputHtmlPart' + pk + 'Sort2').val(o['sort2']);
				$('.varHtmlPart' + pk + 'Sort2').text(o['sort2']);
			}
			if(vars.includes('sort3')) {
				$('.inputHtmlPart' + pk + 'Sort3').val(o['sort3']);
				$('.varHtmlPart' + pk + 'Sort3').text(o['sort3']);
			}
			if(vars.includes('sort4')) {
				$('.inputHtmlPart' + pk + 'Sort4').val(o['sort4']);
				$('.varHtmlPart' + pk + 'Sort4').text(o['sort4']);
			}
			if(vars.includes('sort5')) {
				$('.inputHtmlPart' + pk + 'Sort5').val(o['sort5']);
				$('.varHtmlPart' + pk + 'Sort5').text(o['sort5']);
			}
			if(vars.includes('sort6')) {
				$('.inputHtmlPart' + pk + 'Sort6').val(o['sort6']);
				$('.varHtmlPart' + pk + 'Sort6').text(o['sort6']);
			}
			if(vars.includes('sort7')) {
				$('.inputHtmlPart' + pk + 'Sort7').val(o['sort7']);
				$('.varHtmlPart' + pk + 'Sort7').text(o['sort7']);
			}
			if(vars.includes('sort8')) {
				$('.inputHtmlPart' + pk + 'Sort8').val(o['sort8']);
				$('.varHtmlPart' + pk + 'Sort8').text(o['sort8']);
			}
			if(vars.includes('sort9')) {
				$('.inputHtmlPart' + pk + 'Sort9').val(o['sort9']);
				$('.varHtmlPart' + pk + 'Sort9').text(o['sort9']);
			}
			if(vars.includes('sort10')) {
				$('.inputHtmlPart' + pk + 'Sort10').val(o['sort10']);
				$('.varHtmlPart' + pk + 'Sort10').text(o['sort10']);
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
		await patchHtmlPartVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
