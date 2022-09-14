/**
 * Copyright © 2010 浙江邦盛科技有限公司 版权所有
 */
package com.alvinlkk;

import java.util.List;

import lombok.Data;

/**
 * 类的描述
 *
 * @author alvin
 * @date 2022/8/30
 * @since 1.0
 **/
@Data
public class Tree {

    private String treeName;

    private String treeType;

    private List<Leaf> leafs;

    public void treeRoot(int height) {
        class TreeRoot {
            private int rootHeight;

            public void showRootHeight() {
                this.rootHeight = height;
                System.out.println("root height " + height);
            }
        }
        TreeRoot root = new TreeRoot();
        root.showRootHeight();
    }


    @Data
    public class Leaf {
        private String color;

        private String leafSize;

        public void show() {
            System.out.println("tree name: " + Tree.this.treeName);
            System.out.println("tree name: " + treeName);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Leaf leaf = tree.new Leaf();
        tree.treeRoot(100);
    }
}
