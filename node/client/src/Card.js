import Accelerate from "./res/Accelerate.png";
import Aegis from "./res/Aegis.png";
import Age from "./res/Age.png";
import Arcane_bolt from "./res/Arcane_bolt.png";
import Arcane_short from "./res/Arcane_short.png";
import Casting_Blitz from "./res/Casting_Blitz.png";
import Change_Priorities from "./res/Change_Priorities.png";
import Charged_Field from "./res/Charged_Field.png";
import Chilled_Casting from "./res/Chilled_Casting.png";
import Counterspell from "./res/Counterspell.png";
import Decay from "./res/Decay.png";
import Decelerate from "./res/Decelerate.png";
import Defensive_Portal from "./res/Defensive_Portal.png";
import Disorienting_Shift from "./res/Disorienting_Shift.png";
import Fireblast from "./res/Fireblast.png";
import Forceful_casting from "./res/Forceful_casting.png";
import Heated_Casting from "./res/Heated_Casting.png";
import Ignite_spell from "./res/Ignite_spell.png";
import Illusion from "./res/Illusion.png";
import Kinetic_blast from "./res/Kinetic_blast.png";
import Lightbeam from "./res/Lightbeam.png";
import Lightning_bolt from "./res/Lightning_bolt.png";
import Lightning_Storm from "./res/Lightning_Storm.png";
import Mana_Ground from "./res/Mana_Ground.png";
import Mana_siphon from "./res/Mana_siphon.png";
import Plated_Shield from "./res/Plated_Shield.png";
import Rapid_Cast from "./res/Rapid_Cast.png";
import Reactive_Barrier from "./res/Reactive_Barrier.png";
import Redirect from "./res/Redirect.png";
import Robust_Cast from "./res/Robust_Cast.png";
import Spatial_Tear from "./res/Spatial_Tear.png";
import Spelltrick from "./res/Spelltrick.png";
import Stagger from "./res/Stagger.png";
import Stasis from "./res/Stasis.png";
import Supressing_Aura from "./res/Supressing_Aura.png";


var scale = 3;
var cardSize = 50 * scale;

var cardImages = [Accelerate, Aegis, Age, Arcane_bolt, Arcane_short, Casting_Blitz, 
    Change_Priorities, Charged_Field, Chilled_Casting, Counterspell, Decay, Decelerate,
    Defensive_Portal, Disorienting_Shift, Fireblast, Forceful_casting, Heated_Casting, 
    Ignite_spell, Illusion, Kinetic_blast, Lightbeam, Lightning_bolt, Lightning_Storm, 
    Mana_Ground, Mana_siphon, Plated_Shield, Rapid_Cast, Reactive_Barrier, Redirect, 
    Robust_Cast, Spatial_Tear, Spelltrick, Stagger, Stasis, Supressing_Aura];

var cardCosts = [3,5,2,3,2,2,2,3,2,3,5,3,8,4,6,1,3,4,2,2,1,8,3,2,6,3,3,4,7,2,2,3,3,0,4];

export var cardNames = ["Accelerate", "Aegis", "Age", "Arcane_bolt", "Arcane_short", "Casting_Blitz", 
    "Change_Priorities", "Charged_Field", "Chilled_Casting", "Counterspell", "Decay", "Decelerate",
    "Defensive_Portal", "Disorienting_Shift", "Fireblast", "Forceful_casting", "Heated_Casting", 
    "Ignite_spell", "Illusion", "Kinetic_blast", "Lightbeam", "Lightning_bolt", "Lightning_Storm", 
    "Mana_Ground", "Mana_siphon", "Plated_Shield", "Rapid_Cast", "Reactive_Barrier", "Redirect", 
    "Robust_Cast", "Spatial_Tear", "Spelltrick", "Stagger", "Stasis", "Supressing_Aura"];

export function Card({name, click}){
    var img = (
    <button onClick={click}>
        <img src={cardImages[cardNames.indexOf(name)]} width={cardSize}/>
    </button>);
    return img;
}

export function FieldCard({name}){
    var img = <img src={cardImages[cardNames.indexOf(name)]} width={cardSize}/>
    return img;
}