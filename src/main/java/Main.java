public class Main {
    public static void main(String[] args) {


        //System.out.println(s);

        /*String startTime = "2024-07-01 08:00";
        String endTime = "2024-07-20 17:30";
        int id = 433039;
        String sql = "SELECT\n" +
                "\t* \n" +
                "FROM\n" +
                "\tk20 a \n" +
                "WHERE\n" +
                "\ta.A0188 = "+id+" \n" +
                "\tAND (\n" +
                "\t\t( a.k2006 > CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) AND a.k2006 < CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) ) \n" +
                "\t\tOR ( a.k2006 <= CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) AND a.k2007 >= CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) ) \n" +
                "\t\tOR ( a.k2007 > CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) AND a.k2007 < CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) ) \n" +
                "\t)";
        *//*String sql = "SELECT *\n" +
                "FROM\n" +
                "\tk07 a \n" +
                "WHERE\n" +
                "\ta.k0701 = (SELECT CONVERT\n" +
                "\t(\n" +
                "\t\tDATETIME,\n" +
                "\t\t'1900-01-01 ' + '"+time+"' ))\n" +
                "\t\tAND a.k0700 = (select CONVERT ( DATETIME, '"+date+"', 120 ))  and a.A0188 = "+ HRid;*//*
        System.out.println(sql);
        String spk = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqAClqpl6lGnLPuR3tx4OBJa8rhAo+WhxUQKjU7XFoGBMCTVPPeGJ8SWG5JynxHJl681i84WL2FP6gX+5Trleq/VKlCQESJEU2r2EYEYUHoZ9PD9ELlaJHCd2fySlSK8cCME7iFSJ4VI3TkTD91L+yJzFpL9110VegN1Ss3s0X12qO1uCrBx5henfMuCd7xk/cW9uOqoUWBShd/n95CJnhXSHVSVV32WwybFDTmUN12X56++o/fBr3MTCtxpZjog4k6rurzwOqX7YEEKgpoIEHU0ypZ1z2uNtl8XK7Qla0XgILz69z1YB6hbnsdAXQRQYWVEtnK77wU2yZigDE/TQ6QIDAQAB";
        RSA rsa = new RSA(null,spk);
        String secret = "5a2e2238-4bdf-4145-b578-5a05077939a3";
        String encryptSecret = rsa.encryptBase64(secret, CharsetUtil.CHARSET_UTF_8,KeyType.PublicKey);
        System.out.println(encryptSecret);

        System.out.println("\n==============================\n");
        //对用户信息进行加密传输,暂仅支持传输OA用户ID
        String encryptUserid = rsa.encryptBase64("231129",CharsetUtil.CHARSET_UTF_8,KeyType.PublicKey);*/
        System.out.println(initiatedA());
    }
    public static String initiatedA(){
        return "{\n" +
                "    \"applicant\": {\n" +
                "        \"employeeID\": \"A0117856\"\n" +
                "    },\n" +
                "    \"currencyCode\": \"CNY\",\n" +
                "    \"companyCode\": \"10\",\n" +
                "    \"custFormValues\": [\n" +
                "        {\n" +
                "            \"fieldOID\": \"4b13b9a8-f58b-4435-9441-e020f3948238\",\n" +
                "            \"messageKey\": \"select_company\",\n" +
                "            \"value\": \"4be6a6ca-8705-4c0d-ab8f-bfa229df5bf0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"select_cost_center\",\n" +
                "            \"fieldOID\": \"e815c050-57fc-4eea-b2d6-2b445a98059c\",\n" +
                "            \"fieldName\": \"部门\",\n" +
                "            \"value\": \"\",\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"出差类型\",\n" +
                "            \"fieldType\": \"CUSTOM_ENUMERATION\",\n" +
                "            \"fieldOID\": \"13c7d60c-3af0-49ce-88be-0f41d811aa54\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"value\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"start_date\",\n" +
                "            \"fieldOID\": \"390f6601-4d28-46c3-a93a-e057faca1175\",\n" +
                "            \"name\": \"2024-07-08T16:00:00Z\",\n" +
                "            \"value\": \"2024-07-19\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"b98318d1-906b-49aa-9e86-2bca8f280808\",\n" +
                "            \"name\": \"2024-07-16T15:59:00Z\",\n" +
                "            \"value\": \"2024-07-26\",\n" +
                "            \"messageKey\": \"end_date\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"241ed88f-96fb-4209-8c29-fc9c8ba1459e\",\n" +
                "            \"fieldName\": \"出差城市\",\n" +
                "            \"name\": \"CHN044019000\",\n" +
                "            \"value\": \"CHN044019000\",\n" +
                "            \"messageKey\": \"city\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"4e51e534-75fa-48a9-b7b7-7313f4fa4154\",\n" +
                "            \"fieldName\": \"参与人员（系统控件）\",\n" +
                "            \"messageKey\": \"select_participant\",\n" +
                "            \"value\": \"A0117856\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"45c7335f-1922-4a69-ae10-d871e95d40d0\",\n" +
                "            \"fieldName\": \"参与人\",\n" +
                "            \"fieldType\": \"TEXT\",\n" +
                "            \"fieldTypeId\": 101,\n" +
                "            \"name\": \"毛云龙 张欢欢\",\n" +
                "            \"value\": \"毛云龙\",\n" +
                "            \"messageKey\": \"input\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"687c8119-061a-4203-b4ab-5d0e35bf69a7\",\n" +
                "            \"fieldName\": \"出差事由\",\n" +
                "            \"messageKey\": \"title\",\n" +
                "            \"value\": \"出差深圳长盈精密~\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"cb777a1a-fea0-4092-a88f-49320d0c3f05\",\n" +
                "            \"fieldName\": \"预定机票\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"value\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"eca7476b-6a28-47ab-b077-304577a5a0f1\",\n" +
                "            \"fieldName\": \"预支旅费\",\n" +
                "            \"value\": \"50000.00\",\n" +
                "            \"messageKey\": \"number\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"工作代理人\",\n" +
                "            \"fieldOID\": \"dd1cc8e2-eb54-419e-84fb-cd26a2361c2e\",\n" +
                "            \"value\": \"4d0e7d7f-096d-4b3e-b627-dfaaaec15e7d\",\n" +
                "            \"messageKey\": \"select_user\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"附件\",\n" +
                "            \"fieldOID\": \"fd587576-6cf5-4503-94a5-b1fe17b81b9c\",\n" +
                "            \"messageKey\": \"attachment\",\n" +
                "            \"value\": \"[{\\\"attachmentOID\\\":\\\"71c5f586-cce5-4028-b654-9418fb653bfe\\\"}]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"input\",\n" +
                "            \"fieldName\": \"项目号说明\",\n" +
                "            \"fieldOID\": \"ada4cc79-51af-47f2-a2af-f20dec5c89ad\",\n" +
                "            \"value\": \"项目号说明123\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"formOID\": \"f3eb46e7-b133-49ca-885f-31eac722b38c\",\n" +
                "    \"formType\": 2001,\n" +
                "    \"status\": 1003,\n" +
                "    \"travelApplication\": {},\n" +
                "    \"type\": 1002\n" +
                "}";
    }
    public static String initiatedB(){
        return "{\n" +
                "    \"applicant\": {\n" +
                "        \"employeeID\": \"A0117856\"\n" +
                "    },\n" +
                "    \"currencyCode\": \"CNY\",\n" +
                "    \"companyCode\": \"10\",\n" +
                "    \"custFormValues\": [\n" +
                "        {\n" +
                "            \"fieldCode\": \"company\",\n" +
                "            \"messageKey\": \"select_company\",\n" +
                "            \"value\": \"4be6a6ca-8705-4c0d-ab8f-bfa229df5bf0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"select_cost_center\",\n" +
                "            \"fieldCode\": \"department\",\n" +
                "            \"fieldName\": \"部门\",\n" +
                "            \"value\": \"\",\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"出差类型\",\n" +
                "            \"fieldType\": \"CUSTOM_ENUMERATION\",\n" +
                "            \"fieldCode\": \"travelType\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"value\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"start_date\",\n" +
                "            \"fieldCode\": \"start_date\",\n" +
                "            \"name\": \"2024-07-08T16:00:00Z\",\n" +
                "            \"value\": \"2024-07-19\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"end_date\",\n" +
                "            \"name\": \"2024-07-16T15:59:00Z\",\n" +
                "            \"value\": \"2024-07-26\",\n" +
                "            \"messageKey\": \"end_date\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"city\",\n" +
                "            \"fieldName\": \"出差城市\",\n" +
                "            \"name\": \"CHN044019000\",\n" +
                "            \"value\": \"CHN044019000\",\n" +
                "            \"messageKey\": \"city\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"4e51e534-75fa-48a9-b7b7-7313f4fa4154\",\n" +
                "            \"fieldName\": \"参与人员（系统控件）\",\n" +
                "            \"messageKey\": \"select_participant\",\n" +
                "            \"value\": \"A0117856\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"participant\",\n" +
                "            \"fieldName\": \"参与人\",\n" +
                "            \"fieldType\": \"TEXT\",\n" +
                "            \"fieldTypeId\": 101,\n" +
                "            \"name\": \"毛云龙 张欢欢\",\n" +
                "            \"value\": \"毛云龙\",\n" +
                "            \"messageKey\": \"input\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"businessReason\",\n" +
                "            \"fieldName\": \"出差事由\",\n" +
                "            \"messageKey\": \"title\",\n" +
                "            \"value\": \"出差深圳长盈精密~\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"isOrderAirTicket\",\n" +
                "            \"fieldName\": \"预定机票\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"value\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"eca7476b-6a28-47ab-b077-304577a5a0f1\",\n" +
                "            \"fieldName\": \"预支旅费\",\n" +
                "            \"value\": \"50000.00\",\n" +
                "            \"messageKey\": \"number\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"工作代理人\",\n" +
                "            \"fieldOID\": \"dd1cc8e2-eb54-419e-84fb-cd26a2361c2e\",\n" +
                "            \"value\": \"4d0e7d7f-096d-4b3e-b627-dfaaaec15e7d\",\n" +
                "            \"messageKey\": \"select_user\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"附件\",\n" +
                "            \"fieldOID\": \"fd587576-6cf5-4503-94a5-b1fe17b81b9c\",\n" +
                "            \"messageKey\": \"attachment\",\n" +
                "            \"value\": \"[{\\\"attachmentOID\\\":\\\"71c5f586-cce5-4028-b654-9418fb653bfe\\\"}]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"input\",\n" +
                "            \"fieldName\": \"项目号说明\",\n" +
                "            \"fieldOID\": \"ada4cc79-51af-47f2-a2af-f20dec5c89ad\",\n" +
                "            \"value\": \"项目号说明123\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"formOID\": \"f3eb46e7-b133-49ca-885f-31eac722b38c\",\n" +
                "    \"formType\": 2001,\n" +
                "    \"status\": 1003,\n" +
                "    \"travelApplication\": {},\n" +
                "    \"type\": 1002\n" +
                "}";
    }
}