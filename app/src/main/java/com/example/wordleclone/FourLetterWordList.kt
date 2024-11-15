package com.example.wordleclone

object FourLetterWordList {

    private val words = listOf("AREA", "BABY", "BACK", "BALL", "BANK", "BASE", "BATH", "BEAR", "BILL", "BIRD", "BOAT", "BODY", "BONE", "BOOK", "CALL", "CARD", "CARE", "CASH", "CITY", "CLUB", "COOK", "COST", "DATE", "DEAL", "DOOR", "DUST", "EAST", "FACE", "FALL", "FARM", "FAST", "FEAR", "FISH", "FOOD", "FOOT", "FREE", "GIRL", "GOAL", "GOLD", "HAIR", "HALF", "HAND", "HARD", "HEAD", "HELP", "HOME", "HOPE", "HOUR", "IDEA", "JUMP", "KEEP", "KILL", "KING", "LAND", "LATE", "LEAD", "LEFT", "LIFE", "LINE", "LOOK", "LOSS", "LOVE", "MAKE", "MARK", "MIND", "MOVE", "NAME", "NEED", "NEWS", "NOTE", "ONLY", "OPEN", "OVER", "PAGE", "PAIN", "PART", "PASS", "PLAN", "PLAY", "POST", "RACE", "RATE", "READ", "REST", "RICH", "RING", "ROAD", "ROLE", "ROOM", "RULE", "SAFE", "SALE", "SAME", "SEAT", "SHOP", "SHOW", "SIDE", "SIGN", "SITE", "SIZE", "SKIN", "SLOW", "SNOW", "SONG", "SORT", "SOUL", "STAR", "STEP", "STOP", "TIME", "TREE", "TURN", "VIEW", "WALL", "WANT", "WARM", "WASH", "WEEK", "WEST", "WIND", "WINE", "WOOD", "WORD", "WORK", "YEAR")


    fun getRandomFourLetterWord(): String {
        return words.random()
    }
}
