/**
 * @author Chenya Zhang
 * 07/18/2016
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public abstract class Action {
        public abstract String getName();

        public abstract String perform(HttpServletRequest request);

        private static Map<String, Action> hashmap = new HashMap<String, Action>();

        public static void add(Action action) {
                synchronized (hashmap) {

                        if (hashmap.get(action.getName()) != null) {
                                throw new AssertionError("Two actions with the same name (" + action.getName() + "): "
                                                + action.getClass().getName() + " and " + hashmap.get(action.getName()).getClass().getName());
                        }

                        hashmap.put(action.getName(), action);
                }
        }

        public static String perform(String name, HttpServletRequest request) {
                Action action;
                synchronized (hashmap) {
                        action = hashmap.get(name);
                }

                if (action == null)
                        return null;
                return action.perform(request);
        }
}
