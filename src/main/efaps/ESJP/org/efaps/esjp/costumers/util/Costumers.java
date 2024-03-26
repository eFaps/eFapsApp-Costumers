/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
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
 */
package org.efaps.esjp.costumers.util;

import java.util.UUID;

import org.efaps.admin.common.SystemConfiguration;
import org.efaps.admin.program.esjp.EFapsApplication;
import org.efaps.admin.program.esjp.EFapsUUID;
import org.efaps.api.annotation.EFapsSysConfAttribute;
import org.efaps.api.annotation.EFapsSystemConfiguration;
import org.efaps.esjp.admin.common.systemconfiguration.BooleanSysConfAttribute;
import org.efaps.esjp.admin.common.systemconfiguration.StringSysConfAttribute;
import org.efaps.esjp.ci.CINumGenCostumers;
import org.efaps.util.cache.CacheReloadException;

/**
 *
 * @author The eFaps Team
 */
@EFapsUUID("325efa96-6e63-487d-90d4-885e60f40091")
@EFapsApplication("eFapsApp-Costumers")
@EFapsSystemConfiguration("072ab9d0-bcd6-4694-b851-01c755db5a5a")
public final class Costumers
{
    /** The base. */
    public static final String BASE = "org.efaps.costumers.";

    /** Costumers-Configuration. */
    public static final UUID SYSCONFUUID = UUID.fromString("072ab9d0-bcd6-4694-b851-01c755db5a5a");

    /** See description. */
    @EFapsSysConfAttribute
    public static final StringSysConfAttribute OPPORTUNITY_NUMGEN = new StringSysConfAttribute()
                    .sysConfUUID(Costumers.SYSCONFUUID)
                    .key(Costumers.BASE + "Opportunity.NumberGenerator")
                    .defaultValue(CINumGenCostumers.OpportunitySequence.uuid.toString())
                    .description("NumberGenerator for Opportunity.");

    /** See description. */
    @EFapsSysConfAttribute
    public static final BooleanSysConfAttribute OPPORTUNITY_USENUMGEN = new BooleanSysConfAttribute()
                    .sysConfUUID(Costumers.SYSCONFUUID)
                    .key(Costumers.BASE + "Opportunity.UseNumberGenerator")
                    .description("Use a NumberGenerator for the Name for Opportunity.");

    /** See description. */
    @EFapsSysConfAttribute
    public static final BooleanSysConfAttribute OPPORTUNITY_FILESTRBROWSER = new BooleanSysConfAttribute()
                    .sysConfUUID(Costumers.SYSCONFUUID)
                    .key(Costumers.BASE + "Opportunity.ActivateFilesStructurBrowser")
                    .description("Activate the Files StructurBrowser for Opportunity.");
    /** See description. */
    @EFapsSysConfAttribute
    public static final BooleanSysConfAttribute OPPORTUNITY_FILES= new BooleanSysConfAttribute()
                    .sysConfUUID(Costumers.SYSCONFUUID)
                    .key(Costumers.BASE + "Opportunity.ActivateFiles")
                    .description("Activate the Files StructurBrowser for Opportunity.");

    /**
     * Singleton.
     */
    private Costumers()
    {
    }

    /**
     * @return the SystemConfigruation for Costumers
     * @throws CacheReloadException on error
     */
    public static SystemConfiguration getSysConfig()
        throws CacheReloadException
    {
        // Costumers-Configuration
        return SystemConfiguration.get(SYSCONFUUID);
    }
}
