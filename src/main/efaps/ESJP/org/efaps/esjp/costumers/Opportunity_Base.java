/*
 * Copyright 2003 - 2012 The eFaps Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.esjp.costumers;

import org.efaps.admin.datamodel.Status;
import org.efaps.admin.event.Parameter;
import org.efaps.admin.event.Return;
import org.efaps.admin.program.esjp.EFapsRevision;
import org.efaps.admin.program.esjp.EFapsUUID;
import org.efaps.db.Insert;
import org.efaps.db.Instance;
import org.efaps.esjp.ci.CICostumers;
import org.efaps.esjp.ci.CIFormCostumers;
import org.efaps.esjp.erp.CommonDocument;
import org.efaps.util.EFapsException;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
@EFapsUUID("a64ca997-3c47-4bb2-ab02-06bef4cbe349")
@EFapsRevision("$Rev$")
public abstract class Opportunity_Base
    extends CommonDocument
{

    /**
     * Executed from a Command execute vent to create a new CostSheet.
     *
     * @param _parameter Parameter as passed from eFaps API.
     * @return new Return.
     * @throws EFapsException on error.
     */
    public Return create(final Parameter _parameter)
        throws EFapsException
    {
        createDoc(_parameter);
        return new Return();
    }

    /**
     * Create a new CostSheet.
     *
     * @param _parameter Parameter as passed from the eFaps API.
     * @return Instance of the created Document.
     * @throws EFapsException on error.
     */
    protected Instance createDoc(final Parameter _parameter)
        throws EFapsException
    {
        final String date = _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.date.name);
        final Long contactid = Instance.get(
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.contact.name)).getId();

        final Insert insert = new Insert(CICostumers.Opportunity);
        insert.add(CICostumers.Opportunity.Contact, contactid);
        insert.add(CICostumers.Opportunity.Date, date);
        insert.add(CICostumers.Opportunity.Salesperson,
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.salesperson.name));
        insert.add(CICostumers.Opportunity.Name,
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.name4create.name));
        insert.add(CICostumers.Opportunity.Status, Status.find(CICostumers.OpportunityStatus.uuid, "Open").getId());
        insert.add(CICostumers.Opportunity.Revenue,
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.revenue.name));
        insert.add(CICostumers.Opportunity.CurrencyLink,
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.currencyLink.name));
        insert.add(CICostumers.Opportunity.Probability,
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.probability.name));
        insert.add(CICostumers.Opportunity.Note,
                        _parameter.getParameterValue(CIFormCostumers.Costumers_OpportunityForm.note.name));
        insert.execute();
        return insert.getInstance();
    }

}
