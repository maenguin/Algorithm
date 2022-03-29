
package baekJoon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/22860
//노션 링크 : https://delirious-sock-4dc.notion.site/22860-small-681e8ffd04b14fe0a282103b89290426
//문제 유형 : 시뮬레이션, 구현
public class P22860_폴더정리small {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Folder main = new Folder("main");
        Map<String, List<String[]>> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            String p = sc.next();
            String f = sc.next();
            String c = sc.next();
            map.computeIfAbsent(p, s -> new ArrayList<>()).add(new String[]{p, f, c});
        }
        initFolderTree(map, main, main.name);
        main.getFileInfo();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String[] split = sc.next().split("/");
            Folder targetFolder = main;
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("main")) continue;
                targetFolder = (Folder) targetFolder.children.get(split[j]);
            }
            System.out.println(targetFolder.numberOfFileTypes + " " + targetFolder.totalFileCount);
        }
    }

    private static void initFolderTree(Map<String, List<String[]>> map, Folder curFolder, String targetName) {
        if (!map.containsKey(targetName)) return;
        for (String[] strings : map.get(targetName)) {
            String f = strings[1];
            String c = strings[2];
            if (c.equals("1")) {
                Folder newFolder = new Folder(f);
                curFolder.add(f, newFolder);
                initFolderTree(map, newFolder, f);
            } else {
                curFolder.add(f, new File(f));
            }
        }
    }

    private abstract static class Component {

        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract Map<String, Integer> getFileInfo();

    }

    private static class Folder extends Component {

        int numberOfFileTypes = 0;
        int totalFileCount = 0;

        private Map<String, Component> children = new HashMap<>();

        public Folder(String name) {
            super(name);
        }

        public void add(String name, Component component) {
            children.put(name, component);
        }

        @Override
        public Map<String, Integer> getFileInfo() {
            Map<String, Integer> map = new HashMap<>();
            for (Component child : children.values()) {
                Map<String, Integer> fileInfo = child.getFileInfo();
                for (String s : fileInfo.keySet()) {
                    map.put(s, map.getOrDefault(s, 0) + fileInfo.get(s));
                }
            }
            for (Integer value : map.values()) {
                totalFileCount += value;
            }
            numberOfFileTypes = map.size();
            return map;
        }

    }

    private static class File extends Component {

        public File(String name) {
            super(name);
        }

        @Override
        public Map<String, Integer> getFileInfo() {
            return Collections.singletonMap(name, 1);
        }

    }

}
