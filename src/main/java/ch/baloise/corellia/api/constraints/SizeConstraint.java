/*
 * Copyright 2018 Baloise Group
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
package ch.baloise.corellia.api.constraints;

public class SizeConstraint {
    public final static int FIRST_NAME_MIN_SIZE = 2;
    public final static int FIRST_NAME_MAX_SIZE = 35;
    public final static int LAST_NAME_MIN_SIZE = 2;
    public final static int LAST_NAME_MAX_SIZE = 35;

    public final static int EMAIL_MIN_SIZE = 2;
    public final static int EMAIL_MAX_SIZE = 70;
    public final static int PHONE_NUMBER_MIN_SIZE = 5;
    public final static int PHONE_NUMBER_MAX_SIZE = 20;

    public final static int LANGUAGE_SIZE = 2;

    public final static int COMPANY_NAME_MIN_SIZE = 3;
    public final static int COMPANY_NAME_MAX_SIZE = 70;
    public final static int UID_NUMBER_MAX_SIZE = 15;

    public final static int AGENT_NUMBER_MAX_SIZE = 8;

    public final static int STREET_MAX_SIZE = 35;
    public final static int HOUSE_NUMBER_MAX_SIZE = 10;
    public final static int ZIP_CODE_SIZE = 4;
    public final static int CITY_MAX_SIZE = 10;

    public final static int LIST_MAX_SIZE = 99;
    public final static int MONTH_YEAR_SIZE = 4;
    public final static int FILE_NAME_MAX_SIZE = 256;
    public final static int MESSAGE_MIN_SIZE = 1;
    public final static int MESSAGE_MAX_SIZE = 1024;

    public final static int CONTRACT_ID_MAX_SIZE = 20;

    public final static int CONTRACT_REFERENCE_MIN_SIZE = 1;
    public final static int CONTRACT_REFERENCE_MAX_SIZE = 30;

    private SizeConstraint() {
    }
}