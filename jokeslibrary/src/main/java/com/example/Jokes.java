package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {
    public final ArrayList<String> myJokes = new ArrayList<>();

    public Jokes() {
        myJokes.add("A man walks into a bar with a roll of tarmac under his arm and says: ''Pint please, and one for the road");
        myJokes.add("I went to the doctors the other day and I said, 'Have you got anything for wind?' So he gave me a kite");
        myJokes.add("My mother-in-law fell down a wishing well, I was amazed, I never knew they worked.");
        myJokes.add("I saw this bloke chatting up a cheetah; I thought, ''He's trying to pull a fast one");
        myJokes.add("There's two fish in a tank, and one says ''How do you drive this thing?");
        myJokes.add("I met a Dutch girl with inflatable shoes last week, phoned her up to arrange a date but unfortunately she'd popped her clogs");
        myJokes.add("A jump-lead walks into a bar. The barman says ''I'll serve you, but don't start anything");
        myJokes.add("A sandwich walks into a bar. The barman says ''Sorry we don't serve food in here");

    }

    public String getMyJokes() {
        Random random = new Random();
        int x = random.nextInt(myJokes.size());
        String myJoke = myJokes.get(x);
        return myJoke;
    }
}
