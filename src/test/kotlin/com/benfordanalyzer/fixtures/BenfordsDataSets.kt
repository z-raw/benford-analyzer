// File: src/test/kotlin/com/benfordanalyzer/fixtures/BenfordsDataSets.kt
package com.benfordanalyzer.fixtures

object BenfordsDataSets {

    const val COUNTRIES_AREA =
    """
        Russia
        17098246.0
        Antarctica
        14200000.0
        Canada[Note 3]
        9984670.0
        China
        9596961.0
        United State
        9525067.0
        Brazil
        8515767.0
        Australia
        7692024.0
        India
        3287263.0
        Argentina
        2780400.0
        Kazakhstan
        2724900.0
        Algeria
        2381741.0
        DR Congo
        2344858.0
        Kingdom of Denmark
        2220093.0
        Greenland (Denmark)
        2166086.0
        Saudi Arabia
        2149690.0
        Mexico
        1964375.0
        Indonesia
        1904569.0
        Sudan
        1861484.0
        Libya
        1759540.0
        Iran
        1648195.0
        Mongolia
        1564110.0
        Peru
        1285216.0
        Chad
        1284000.0
        Niger
        1267000.0
        Angola
        1246700.0
        Mali
        1240192.0
        South Africa
        1221037.0
        Colombia
        1141748.0
        Ethiopia
        1104300.0
        Bolivia
        1098581.0
        Mauritania
        1030700.0
        Egypt
        1002450.0
        Tanzania
        945087.0
        Nigeria
        923768.0
        Venezuela
        916445.0
        Pakistan
        881913.0
        Namibia
        825615.0
        Mozambique
        801590.0
        Turkey
        783562.0
        Chile
        756102.0
        Zambia
        752612.0
        Myanmar
        676578.0
        Afghanistan
        652864.0
        South Sudan
        644329.0
        France
        640679.0
        Somalia
        637657.0
        Central African Republic
        622984.0
        Ukraine
        603500.0
        Madagascar
        587041.0
        Botswana
        581730.0
        Kenya
        580367.0
        Yemen
        555000.0
        France (metropolitan)
        543940.0
        Thailand
        513120.0
        Spain
        505992.0
        Turkmenistan
        488100.0
        Cameroon
        475442.0
        Papua New Guinea
        462840.0
        Sweden
        450295.0
        Uzbekistan
        447400.0
        Morocco
        446550.0
        Iraq
        438317.0
        Paraguay
        406752.0
        Zimbabwe
        390757.0
        Norway
        385207.0
        Japan
        377976.0
        Germany
        357114.0
        Congo
        342000.0
        Finland
        338425.0
        Vietnam
        331212.0
        Malaysia
        330803.0
        Norway (mainland)
        323802.0
        Ivory Coast
        322463.0
        Poland
        312696.0
        Oman
        309500.0
        Italy
        301339.0
        Philippines
        300000.0
        Ecuador
        276841.0
        Burkina Faso
        274222.0
        New Zealand
        270467.0
        Gabon
        267668.0
        Sahrawi Arab Democratic Republic
        266000.0
        Guinea
        245857.0
        United Kingdom
        242495.0
        Uganda
        241550.0
        Ghana
        238533.0
        Romania
        238397.0
        Laos
        236800.0
        Guyana
        214969.0
        Belarus
        207600.0
        Kyrgyzstan
        199951.0
        Senegal
        196722.0
        Syria
        185180.0
        Cambodia
        181035.0
        Uruguay
        176215.0
        Somaliland
        176120.0
        Suriname
        163820.0
        Tunisia
        163610.0
        Bangladesh
        148460.0
        Nepal
        147181.0
        Tajikistan
        143100.0
        Greece
        131957.0
        Nicaragua
        130373.0
        North Korea
        120540.0
        Malawi
        118484.0
        Eritrea
        117600.0
        Benin
        114763.0
        Honduras
        112492.0
        Liberia
        111369.0
        Bulgaria
        111002.0
        Cuba
        109884.0
        Guatemala
        108889.0
        Iceland
        103000.0
        South Korea
        100210.0
        Hungary
        93028.0
        Portugal
        92226.0
        Jordan
        89342.0
        Serbia
        88361.0
        Azerbaijan
        86600.0
        Austria
        83871.0
        United Arab Emirates
        83600.0
        Czech Republic
        78871.0
        Panama
        75417.0
        Sierra Leone
        71740.0
        Ireland
        70273.0
        Georgia
        69700.0
        Sri Lanka
        65610.0
        Lithuania
        65300.0
        Latvia
        64559.0
        Svalbard (Norway)
        62045.0
        Togo
        56785.0
        Croatia
        56594.0
        Bosnia and Herzegovina
        51209.0
        Costa Rica
        51100.0
        Slovakia
        49037.0
        Dominican Republic
        48671.0
        Estonia
        45227.0
        Denmark
        43094.0
        Netherlands
        41850.0
        Switzerland
        41284.0
        Bhutan
        38394.0
        Taiwan
        36193.0
        Guinea-Bissau
        36125.0
        Moldova
        33846.0
        Belgium
        30528.0
        Lesotho
        30355.0
        Armenia
        29743.0
        Solomon Islands
        28896.0
        Albania
        28748.0
        Equatorial Guinea
        28051.0
        Burundi
        27834.0
        Haiti
        27750.0
        Rwanda
        26338.0
        North Macedonia
        25713.0
        Djibouti
        23200.0
        Belize
        22966.0
        El Salvador
        21041.0
        Israel
        20770.0
        Slovenia
        20273.0
        New Caledonia (France)
        18575.0
        Fiji
        18272.0
        Kuwait
        17818.0
        Eswatini
        17364.0
        East Timor
        14919.0
        Bahamas
        13943.0
        Montenegro
        13812.0
        Vanuatu
        12189.0
        Falkland Islands (United Kingdom)
        12173.0
        Qatar
        11586.0
        Gambia
        11295.0
        Jamaica
        10991.0
        Kosovo
        10887.0
        Lebanon
        10452.0
        Cyprus
        9251.0
        Puerto Rico (United States)
        9104.0
        Abkhazia
        8660.0
        French Southern Territories (France)
        7747.0
        United States Minor Outlying Islands
        6959.41
        Palestine
        6020.0
        Brunei
        5765.0
        Trinidad and Tobago
        5130.0
        French Polynesia (France)
        4167.0
        Transnistria
        4163.0
        Cape Verde
        4033.0
        South Georgia and the South Sandwich Islands (United Kingdom)
        3903.0
        South Ossetia
        3900.0
        Northern Cyprus
        3355.0
        Artsakh
        3170.0
        Samoa
        2842.0
        Hong Kong (China)
        2755.0
        Luxembourg
        2586.0
        Bir Tawil (terra nullius)
        2060.0
        Mauritius
        2040.0
        Comoros
        1862.0
        Åland (Finland)
        1580.0
        Faroe Islands (Denmark)
        1393.0
        São Tomé and Príncipe
        964.0
        Turks and Caicos Islands (United Kingdom)
        948.0
        Kiribati
        811.0
        Bahrain
        785.0
        Dominica
        751.0
        Tonga
        747.0
        Singapore
        728.0
        Micronesia
        702.0
        Saint Lucia
        616.0
        Isle of Man (British Crown dependency)
        572.0
        Guam (United States)
        549.0
        Andorra
        468.0
        Northern Mariana Islands (United States)
        464.0
        Palau
        459.0
        Seychelles
        452.0
        Curaçao (Netherlands)
        444.0
        Antigua and Barbuda
        442.0
        Barbados
        430.0
        Heard Island and McDonald Islands (Australia)
        412.0
        Saint Vincent and the Grenadines
        389.0
        Jan Mayen (Norway)
        377.0
        U.S. Virgin Islands (United States)
        347.0
        Grenada
        344.0
        Malta
        316.0
        Saint Helena, Ascension and Tristan da Cunha (United Kingdom)
        308.0
        Maldives
        300.0
        Bonaire (Netherlands)
        294.0
        Cayman Islands (United Kingdom)
        264.0
        Saint Kitts and Nevis
        261.0
        Niue (New Zealand)
        260.0
        Akrotiri and Dhekelia (United Kingdom)
        253.8
        Saint Pierre and Miquelon (France)
        242.0
        Cook Islands (New Zealand)
        236.0
        American Samoa (United States)
        199.0
        Marshall Islands
        181.0
        Aruba (Netherlands)
        180.0
        Liechtenstein
        160.0
        British Virgin Islands (United Kingdom)
        151.0
        Wallis and Futuna (France)
        142.0
        Christmas Island (Australia)
        135.0
        Jersey (British Crown dependency)
        116.0
        Montserrat (United Kingdom)
        102.0
        Anguilla (United Kingdom)
        91.0
        Guernsey (British Crown dependency)
        78.0
        San Marino
        61.0
        British Indian Ocean Territory (United Kingdom)
        60.0
        Saint Martin (France)
        54.0
        Bermuda (United Kingdom)
        54.0
        Bouvet Island (Norway)
        49.0
        Pitcairn Islands (United Kingdom)
        47.0
        Norfolk Island (Australia)
        36.0
        Sint Maarten (Netherlands)
        34.0
        Macau (China)
        31.3
        Tuvalu
        26.0
        Nauru
        21.0
        Saint Barthélemy (France)
        21.0
        Sint Eustatius (Netherlands)
        21.0
        Cocos (Keeling) Islands (Australia)
        14.0
        Saba (Netherlands)
        13.0
        Tokelau (New Zealand)
        12.0
        Gibraltar (United Kingdom)
        6.0
        Clipperton Island (France)
        6.0
        Ashmore and Cartier Islands (Australia)
        5.0
        Spratly Islands (disputed)
        5.0
        Coral Sea Islands (Australia)
        3.0
        Monaco
        2.02
        Vatican City
        0.49
    """
}