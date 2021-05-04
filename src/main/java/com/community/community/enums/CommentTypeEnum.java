package com.community.community.enums;

public enum CommentTypeEnum {//评论类型
    QUESTION(1),
    COMMENT(2);

    private Integer type;
    public Integer getType() {
        return type;
    }

    CommentTypeEnum(int type) {
        this.type=type;
    }
    public static boolean isExist(Integer type){
        for(CommentTypeEnum commentTypeEnum: CommentTypeEnum.values()){
            if(type==commentTypeEnum.getType()) {
                return true;
            }
        }
        return false;
    }
}
