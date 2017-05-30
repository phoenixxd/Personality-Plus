package productions.phoenixxl.personality_plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by abhishek on 14/5/17.
 */

public class data {
    static int size = 20;

    data(){
        super();

        mymap = new ArrayList<ArrayList<String>>();
        smap = new LinkedHashMap<>();
        dict = new HashMap<>();

        setDict();

        for(int j = 0; j < 8; j++){
            ArrayList<String> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                try{
                    String ins = ((String[])arr[j])[i];
                    temp.add(ins);
                    smap.put(ins , j);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            mymap.add(temp);
        }

    }

    List<ArrayList<String>> mymap ;
    LinkedHashMap<String, Integer> smap ;

    static HashMap<String, String> dict;

    String sanguinep[] = {"Animated", "Playful", "Sociable", "Convincing", "Refreshing", "Spirited", "Promoter", "Spontaneous", "Optimistic", "Funny",
            "Delightful", "Cheerful", "Inspiring", "Demonstrative", "Mixes easily", "Talker", "Lively", "Cute", "Popular", "Bouncy"};

    String meloncholyp[] = {"Analytical", "Persistent", "Self-sacrificing", "Considerate", "Respectful", "Sensitive", "Planner", "Scheduled", "Orderly"
            ,"Faithful", "Detailed", "Cultured", "Idealistic", "Deep", "Musical", "Thoughtful", "Loyal", "Chartmaker", "Perfectionist", "Behaved"};

    String cholericp[] = {"Adventurous", "Persuasive", "Strong-Willed", "Competitive", "Resourceful", "Self-reliant", "Positive", "Sure", "Outspoken",
            "Forceful", "Daring", "Confident", "Independent", "Decisive", "Mover", "Tenacious", "Leader", "Chief", "Productive", "Bold"};

    String phlegmaticp[] = {"Adaptable", "Peaceful", "Submissive", "Controlled", "Reserved", "Satisfied", "Patient", "Shy", "Obliging", "Friendly",
            "Diplomatic", "Consistent", "Inoffensive", "Dry humour", "Mediator", "Tolerant", "Listener", "Contented", "Pleasant", "Balanced"};

    String phlegmaticn[] = {"Blank", "Unenthusiastic","Reticent","Fearful","Indecisive","Uninvolved","Hesitant","Plain","Aimless","Nonchalant",
            "Worrier","Timid","Doubtful","Indifferent","Mumbles","Slow","Lazy","Sluggish","Reluctant", "Compromising"};

    String sanguinen[] = {"Brassy","Undisciplined","Repetitious","Forgetful","Interrupts","Unpredictable","Haphazard","Permissive","Angered easily","Naive","Wants credit",
            "Talkative","Disorganised","Inconsistent","Messy","Show-off","Loud","Scatterbrained","Restless","Changeable"};


    String cholericn[] = {"Bossy","Unsympathetic","Resistant","Frank","Impatient","Unaffectionate","Headstrong","Proud","Argumentative","Nervy",
            "Workaholic","Tactless","Domineering","Intolerant","Manipulative","Stubborn","Lord over others","Short-Tempered","Rash","Crafty"};

    String meloncholyn[] = {"Bashful","Unforgiving","Resentful","Fussy",
            "Insecure","Unpopular","Hard to please","Pessimistic","Alienated","Negative attitude",
            "Withdrawn","Too sensitive","Depressed","Introvert","Moody","Skeptical","Loner","Suspicious","Revengeful","Critical"};

    Object arr[] = {sanguinep, meloncholyp, cholericp, phlegmaticp, sanguinen, meloncholyn, cholericn, phlegmaticn};

    void setDict(){
        dict.put("Start", "~");
        dict.put("Animated", " alive, enlivened, full of life, lively");
        dict.put("Playful", " full of fun and good humour");
        dict.put("Sociable", " clubable, feels to be with others is entertaining");
        dict.put("Convincing", " persuasive, can change ones perspective");
        dict.put("Refreshing", " makes others feel good");
        dict.put("Spirited", " full of excitement");
        dict.put("Promoter", " urges people to come along or join him");
        dict.put("Spontaneous", " not restricted by plans, impulsive");
        dict.put("Optimistic", " affirmative, cheerful, positive");
        dict.put("Funny", " amusing, comical, laughable");
        dict.put("Delightful", " fun to be with, pleasing");
        dict.put("Cheerful", " upbeat, beaming, promoting happiness in others");
        dict.put("Inspiring", " ennobling, exalting, encourages others to work");
        dict.put("Demonstrative", " illustrative, affectionate, emotional");
        dict.put("Mixes easily", "~");
        dict.put("Talker", " speaker, utterer, verbaliser");
        dict.put("Lively", " vigorous, energitic");
        dict.put("Cute", " center of attraction, precious, adorable, attractive");
        dict.put("Popular", " life of the party");
        dict.put("Bouncy", " lively, resilient, springy, energetic");
        dict.put("Analytical", " like to examine the parts for their logical and proper relationships");
        dict.put("Persistent", " completes one project before moving to another");
        dict.put("Self-sacrificing", " self-denying, unselfish");
        dict.put("Considerate", " thoughtful, caring");
        dict.put("Respectful", " treats others with honor and esteem");
        dict.put("Sensitive", " sensible, sore, raw, tender");
        dict.put("Planner", " one who plans the strategy before starting a task and sticks to the plan");
        dict.put("Scheduled", " lives according to a plan, dislikes the plan getting interrupted");
        dict.put("Orderly", " with systematic management of things");
        dict.put("Faithful", " reliable, loyal, steadfast");
        dict.put("Detailed", " does everything in proper order with a clear memory of all the things that happen");
        dict.put("Cultured", " one whose interests involve both intellectual and artistic pursuits, such as theater, symphony and ballet");
        dict.put("Idealistic", " visualises things to a perfect form");
        dict.put("Deep", " intense people who don't like surface conversation");
        dict.put("Musical", " melodious, deep appreciation for music");
        dict.put("Thoughtful", " paying attention to special occasions and is quick to make a kind gesture");
        dict.put("Loyal", " patriotic, firm, true-hearted, fast");
        dict.put("Chartmaker", "one who makes charts, graphs or tables to get things done");
        dict.put("Perfectionist", " places high standards on himself and others");
        dict.put("Behaved", "polite, gentle");
        dict.put("Adventurous", " adventuresome, audacious, daring, sporting");
        dict.put("Persuasive", " coaxing, cogent, compelling, convincing");
        dict.put("Strong-Willed", " strong-minded, obstinate, stubborn");
        dict.put("Competitive", " turns everything into a contest and plays to win");
        dict.put("Resourceful", " able to act effectively and quickly in all situations");
        dict.put("Self-reliant", " autonomous, self-directed, independent");
        dict.put("Positive", " pdlus, confirming, prescribed, incontrovertible");
        dict.put("Sure", " certain, trusted, indisputable, certain");
        dict.put("Outspoken", " vocal, blunt, candid, forthright");
        dict.put("Forceful", " emphatic, emphatic, assertive, bruising");
        dict.put("Daring", " audacious, venturesome, venturous, avant-garde");
        dict.put("Confident", " surefooted, sure-footed, convinced, positive");
        dict.put("Independent", " autonomous, self-governing, sovereign, main");
        dict.put("Decisive", " a person with quick, conclusive decision making ability");
        dict.put("Mover", " one who finds guilty to sit still");
        dict.put("Tenacious", " very stubborn to get the goal accomplished");
        dict.put("Leader", " one who takes the charge mostly");
        dict.put("Chief", " commands leadership and expects others to follow");
        dict.put("Productive", " must constantly be producing and achieving");
        dict.put("Bold", " fearless, daring, unafraid of risk");
        dict.put("Adaptable", " adjustable, all-mains, convertible, flexible in situations");
        dict.put("Peaceful", " passive, law-abiding, dovish");
        dict.put("Submissive", " agrees to others easily, abject, bowed");
        dict.put("Controlled", " restricts his emotions");
        dict.put("Reserved", " restrained, reticent, unemotional, aloof");
        dict.put("Satisfied", " quenched, slaked, content, contented");
        dict.put("Patient", " diligent, enduring, forbearing, long-suffering");
        dict.put("Shy", " quiet, doesn't easily start a conversation");
        dict.put("Obliging", " one who is quick to do it someone else's way");
        dict.put("Friendly", " favorable, well-disposed, affable, amiable");
        dict.put("Diplomatic", " doesn't take side of good or bad, remains neutral");
        dict.put("Consistent", " reproducible, coherent, ordered");
        dict.put("Inoffensive", " a person who never says anything unpleasant or objectionable");
        dict.put("Dry humour", "sarcastic comedy");
        dict.put("Mediator", " one who solves the conflicts between two parties");
        dict.put("Tolerant", " easily accepts others the way they are");
        dict.put("Listener", " hearer, auditor, attender, beholder");
        dict.put("Contented", " satisfied with what they have already");
        dict.put("Pleasant", " enjoyable, grateful");
        dict.put("Balanced", " stable, not high or low personality always in the middle of the road personality");
        dict.put("Blank", " no facial expression");
        dict.put("Unenthusiastic", " cold, halfhearted");
        dict.put("Reticent", " unwilling to get involved in new adventures");
        dict.put("Fearful", " awful, dire, direful, dreaded");
        dict.put("Indecisive", " cant decide by themselves");
        dict.put("Uninvolved", " doesn't like to get involved in group activities or other peoples' lives");
        dict.put("Hesitant", "unsure, or slow in acting or speaking");
        dict.put("Plain", " simple people who like to go with the flow");
        dict.put("Aimless", " directionless, planless, dreamless");
        dict.put("Nonchalant", " casual, insouciant, unconcerned");
        dict.put("Worrier", " consistently feels nervous");
        dict.put("Timid", " run away from difficult situations");
        dict.put("Doubtful", "feeling uncertain about something");
        dict.put("Indifferent", " neutral person, nothing matters them");
        dict.put("Mumbles", " speaks quietly, doesnt like to attract attention");
        dict.put("Slow", " dense, dim, dull, dumb");
        dict.put("Lazy", " faineant, indolent, otiose, slothful");
        dict.put("Sluggish", " dull, slow, inert");
        dict.put("Reluctant", " uneager and unwilling to get involved");
        dict.put("Compromising", " wont argue even when right to avoid conflict");
        dict.put("Brassy", " showy, flashy, too loud");
        dict.put("Undisciplined", " uncorrected, ungoverned, uncontrolled, unpunished");
        dict.put("Repetitious", " tells you the same story again to entertain without realising he has already told the story several times before");
        dict.put("Forgetful", " unretentive, short, unmindful, mindless");
        dict.put("Interrupts", " a person who is more of a talker than a listener");
        dict.put("Unpredictable", " happy one moment then sad the next moment, willing to help but disappears, promises to come but forgets to show up");
        dict.put("Haphazard", " no consistent way of doing things");
        dict.put("Permissive", " allows others to do as they please");
        dict.put("Angered easily", "~");
        dict.put("Naive", " simple and childlike perspective, lacking sophistication");
        dict.put("Wants credit", "~");
        dict.put("Talkative", " chatty, gabby, garrulous, loquacious");
        dict.put("Disorganised", " lack of the ability to get life in order");
        dict.put("Inconsistent", " erratic, actions and emotions not based on logic");
        dict.put("Messy", " unable to find things, due to things not placed properly");
        dict.put("Show-off", " wants to be watched");
        dict.put("Loud", " a person whose voice can be heard over others");
        dict.put("Scatterbrained", " lacks the power of concentration or attention, flighty");
        dict.put("Restless", " likes constant new activity, as its boring to do the same things again");
        dict.put("Changeable", " mutable, childlike, need variety to keep from getting bored");
        dict.put("Bossy", " autocratic, dominating");
        dict.put("Unsympathetic", " finds difficult to relate to hurt of others");
        dict.put("Resistant", " doesn't like anyone else's way");
        dict.put("Frank", " blunt, candid, forthright, free-spoken");
        dict.put("Impatient", " raring, eager, restive, unforbearing");
        dict.put("Unaffectionate", " uncaring, unloving");
        dict.put("Headstrong", " forward, insists on having his own way");
        dict.put("Proud", " gallant, lofty, majestic, arrogant");
        dict.put("Argumentative", " combative, contentious, disputatious, disputative");
        dict.put("Nervy", " full of confidence in a negative sense");
        dict.put("Workaholic", " compulsive, one who likes to work every moment");
        dict.put("Tactless", " sometimes expresses himself in offensive manner");
        dict.put("Domineering", " authoritarian, autocratic, blustery, bossy");
        dict.put("Intolerant", " illiberal, bigoted, narrow, narrow-minded");
        dict.put("Manipulative", " artful");
        dict.put("Stubborn", " obstinate, ziddi :p");
        dict.put("Lord over others", "~");
        dict.put("Short-Tempered", " choleric, irascible, hotheaded, hot-tempered");
        dict.put("Rash", " foolhardy, heady, reckless, bold");
        dict.put("Crafty", " cunning, who always finds way to get the job done maybe the wrong way");
        dict.put("Bashful", " gets nervous when gets attention, stage fear, timid");
        dict.put("Unforgiving", " grim, inexorable, relentless, stern");
        dict.put("Resentful", " bitter, holds ill feeling");
        dict.put("Fussy", " wants great attention for trivial details");
        dict.put("Insecure", " apprehensive, lacks confidence, overanxious");
        dict.put("Unpopular", " not known much, unsocial");
        dict.put("Hard to please", " hard-to-please, demanding");
        dict.put("Pessimistic", " bearish, demoralised, demoralized, discouraged");
        dict.put("Alienated", " estranged, unloved");
        dict.put("Negative attitude", "~");
        dict.put("Withdrawn", " recluse, reclusive, indrawn, reserved");
        dict.put("Too sensitive", "~");
        dict.put("Depressed", " often downhearted");
        dict.put("Introvert", " reserved person");
        dict.put("Moody", " dour, glowering, glum");
        dict.put("Skeptical", " disbelieving, sceptical, unbelieving, doubting");
        dict.put("Loner", " unsocial, likes it alone");
        dict.put("Suspicious", " doubtful, leery, mistrustful, untrusting,");
        dict.put("Revengeful", " vindictive, vengeful, unforgiving");
        dict.put("Critical", " critical appraisal, constantly judging and giving comments");

    }

}
