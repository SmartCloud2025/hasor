/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.test.simple.db._01_insert;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.db.jdbc.core.JdbcTemplate;
import net.hasor.test.utils.HasorUnit;
import net.test.simple.db._07_datasource.warp.OneDataSourceWarp;
import org.junit.Test;
/***
 * 批量Insert语句执行
 * @version : 2014-1-13
 * @author 赵永春(zyc@hasor.net)
 */
public class MapBatch_InsertJDBCTest {
    @Test
    public void baseInsertJDBCTest() throws SQLException {
        System.out.println("--->>baseInsertJDBCTest<<--");
        //
        AppContext app = Hasor.createAppContext("net/test/simple/db/jdbc-config.xml", new OneDataSourceWarp());
        JdbcTemplate jdbc = app.getInstance(JdbcTemplate.class);
        //
        String batchInsert = "insert into TB_User values(:ID,:Name,:Account,:Pwd,:Email,:RegTime);";
        //
        showUserCount(jdbc);//显示当前用户总数
        int count = 10;
        Map<String, Object>[] batchValues = new Map[count];
        for (int i = 0; i < count; i++) {
            batchValues[i] = new HashMap<String, Object>();
            batchValues[i].put("ID", UUID.randomUUID().toString());
            batchValues[i].put("Name", String.format("默认用户_%s", i));
            batchValues[i].put("Account", String.format("acc_%s", i));
            batchValues[i].put("Pwd", String.format("pwd_%s", i));
            batchValues[i].put("Email", String.format("autoUser_%s@hasor.net", i));
            batchValues[i].put("RegTime", new Date());
        }
        jdbc.batchUpdate(batchInsert, batchValues);//批量执行执行插入语句
        HasorUnit.printMapList(jdbc.queryForList("select * from TB_User"));
        //
        showUserCount(jdbc);//显示当前用户总数
    }
    private void showUserCount(JdbcTemplate jdbc) throws SQLException {
        System.out.println(">>>>>  userCount :" + jdbc.queryForInt("select count(*) from TB_User"));
    }
}